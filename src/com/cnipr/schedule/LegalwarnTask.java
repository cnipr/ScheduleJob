package com.cnipr.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import com.eprobiti.trs.TRSConnection;
import com.eprobiti.trs.TRSResultSet;

public class LegalwarnTask extends TimerTask {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 60 * 60 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Thread.sleep is interrupt");
			}
			int week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
			if (week != 4) {//WEDNESDAY=4
				System.out.println("Today is not WEDNESDAY");
				continue;
			}
			System.out.println("Legal warn start");
			execute();
			System.out.println("Legal warn end");
		}
	}

	public void execute() {
		List<UserLegalWarn> warnList = new ArrayList<UserLegalWarn>();
		Connection conn = DataAccess.getOracleConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = (PreparedStatement) conn
					.prepareStatement("select t.* from app_tb_user_legal_warn t, app_tb_user u where t.username=u.username and t.state=1 and u.userstate!=0 and u.expiretime>=sysdate()");
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserLegalWarn warn = new UserLegalWarn();   
				warn.setUuid(rs.getString("UUID"));
				warn.setUsername(rs.getString("USERNAME"));
				warn.setTitle(rs.getString("TITLE"));
				warn.setCreateTime(rs.getDate("CREATE_TIME"));
				warn.setLatestPubDate(rs.getDate("LATEST_PUB_DATE"));
				warn.setState(rs.getInt("STATE"));
				warn.setStrWhere(rs.getString("STR_WHERE"));
				warn.setAns(rs.getString("ANS"));
				warnList.add(warn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataAccess.Close(null, stmt, rs);
		}
		System.out.println("预备预警数量：" + warnList.size());
		int i = 0;
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy.MM.dd");
		for (UserLegalWarn warn : warnList) {
			// InputStream l_urlStream;
			if (i % 50 == 0 || i==warnList.size()-1) {
				System.out.println("已处理：" +  (i+1));
			}
			String timewhere = "";
			String fromtime = "";
			String endtime = "";
			try {
				if (warn.getLatestPubDate() != null) {
					fromtime = s1.format(warn.getLatestPubDate());
				} else {
					fromtime = s1.format(warn.getCreateTime());
				}
			} catch (Exception e) {
				fromtime = "";
			}

			if (fromtime.equals("")) {
				continue;
			}

			endtime = s1.format(new java.util.Date());

			if (fromtime.equals(endtime)) {
				continue;
			}

			timewhere = "(申请号=" + warn.getAns() + ") and (法律状态公告日 >('"
					+ fromtime + "') and 法律状态公告日<=('" + endtime + "'))";
			long newcount = 0;
			TRSConnection trsConnection = Util.getConnect();
			if (trsConnection != null) {
				TRSResultSet trsresultset = null;

				try {
					trsresultset = trsConnection.executeSelect("FLZT",
							timewhere, "", "", "", 2, 115, false);
					if (trsresultset != null) {
						newcount = trsresultset.getRecordCount();
					}
				} catch (Exception e) {
					newcount = 0;
				} finally {
					Util.Close(trsConnection, trsresultset);
				}

			}
			if (newcount > 0) {
				PreparedStatement stmt1 = null;
				try {
					stmt1 = (PreparedStatement) conn
							.prepareStatement("update app_tb_user_legal_warn t set t.TRS_COUNT="
									+ newcount
									+ ", t.latest_pub_date=str_to_date(date_format(sysdate(),'%Y-%m-%d %H:%i:%S'), '%Y-%m-%d %H:%i:%S') where t.uuid='"
									+ warn.getUuid() + "'");
					stmt1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DataAccess.Close(null, stmt1, null);
				}
			}
			i++;
		}
		DataAccess.Close(conn, null, null);
	}
	
	public static void main(String[] args) {
		new LegalwarnTask().execute();
	}

}
