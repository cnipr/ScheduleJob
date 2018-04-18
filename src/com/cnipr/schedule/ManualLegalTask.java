package com.cnipr.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.eprobiti.trs.TRSConnection;
import com.eprobiti.trs.TRSResultSet;

public class ManualLegalTask{

	public  static synchronized void execute(String pubDateStr) throws ParseException {
		SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
		Date pubDate = s1.parse(pubDateStr);
		
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
		System.out.println("count：" + warnList.size());
		int i = 0 ;
		for (UserLegalWarn warn : warnList) {
			if(i % 50 == 0 || i==warnList.size()-1) {
				System.out.println("UserLegalWarn executed num：" + (i+1));
			}
			String timewhere = "(申请号=" + warn.getAns() + ") and (法律状态公告日='" + pubDateStr + "')";
			timewhere = new GetSearchFormat().preprocess(timewhere);
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
					Util.Close(null, trsresultset);
				}				
			}			
			if (newcount >= 0) {				
				long totalcount = 0;
				TRSResultSet trsresultset = null;
				try {
					trsresultset = trsConnection.executeSelect("FLZT",
							"申请号=" + warn.getAns(), "", "", "", 2, 115, false);		
					if (trsresultset != null) {
						totalcount = trsresultset.getRecordCount();
					}
				} catch (Exception e) {
					e.printStackTrace();
					totalcount = 0;
				} finally {
					Util.Close(trsConnection, trsresultset);
				}
				
				System.out.println("add legal his：" + warn.getUuid());
				PreparedStatement stmt1 = null;
				try {
					stmt1 = (PreparedStatement) conn
					.prepareStatement("update app_tb_user_legal_warn t set t.TRS_COUNT="
							+ totalcount
							+ ", t.latest_pub_date=str_to_date(date_format(sysdate(),'%Y-%m-%d %H:%i:%S'), '%Y-%m-%d %H:%i:%S') where t.uuid='"
							+ warn.getUuid() + "'");					
					stmt1.executeUpdate();
					DataAccess.Close(null, stmt1, null);
					
					//验证之前是否执行过预警					
					stmt1 = conn.prepareStatement("select count(*) from app_tb_user_legal_warn_his where WARN_UUID= ? and date_format(warn_date,'%Y%m%d')=?");
					stmt1.setString(1, warn.getUuid());
					stmt1.setString(2, pubDateStr);
					ResultSet rs2 = stmt1.executeQuery();
					rs2.next();
					int count = rs2.getInt(1);
					DataAccess.Close(null, stmt1, rs2);
					if (count == 0) {//insert
						stmt1 = (PreparedStatement) conn
						.prepareStatement("insert into app_tb_user_legal_warn_his(uuid, WARN_UUID, USERNAME, TRS_TABLE, TRS_OPTION, TRS_SYNONYM, TRS_COUNT, WARN_DATE, TRS_EXP, STATE) " +
								"values(?,?,?,?,?,?,?,?,?,?)");
						stmt1.setString(1, UUID.randomUUID().toString());
						stmt1.setString(2, warn.getUuid());
						stmt1.setString(3, warn.getUsername());
						stmt1.setString(4, "");
						stmt1.setInt(5, 2);
						stmt1.setString(6, "");
						stmt1.setLong(7, newcount);
						stmt1.setDate(8, new java.sql.Date(pubDate.getTime()));
						stmt1.setString(9, timewhere);
						stmt1.setInt(10, 0);
						stmt1.executeUpdate();
					} else {//update
						stmt1 = (PreparedStatement) conn
						.prepareStatement("update app_tb_user_legal_warn_his t set t.TRS_COUNT=" + newcount +
								" where WARN_UUID= '"+ warn.getUuid() +"' and date_format(warn_date,'%Y%m%d')= '" + pubDateStr + "'");
						stmt1.executeUpdate();
					}					
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
	
	public static void main(String[] args) throws ParseException {
		ManualLegalTask.execute("20141126");
	}

}
