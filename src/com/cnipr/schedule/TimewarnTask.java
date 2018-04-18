package com.cnipr.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;
import java.util.UUID;

import com.eprobiti.trs.TRSConnection;
import com.eprobiti.trs.TRSConstant;
import com.eprobiti.trs.TRSResultSet;

public class TimewarnTask extends TimerTask {
	
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
			System.out.println("warn start...");
			execute();
			System.out.println("warn end...");
		}
		
	}

	public void execute() {
		List<UserExpWarn> warnList = new ArrayList<UserExpWarn>();
		Connection conn = DataAccess.getOracleConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = (PreparedStatement) conn
					.prepareStatement("select t.* from app_tb_user_exp_warn t, app_tb_user u where t.username=u.username and t.state=1 and u.userstate!=0 and u.expiretime>=sysdate()");
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserExpWarn warn = new UserExpWarn();
				warn.setUuid(rs.getString("uuid"));
				warn.setUsername(rs.getString("USERNAME"));
				warn.setUpdateDate(rs.getDate("UPDATE_DATE"));
				warn.setCreateDate(rs.getDate("CREATE_DATE"));
				
				warn.setExp(rs.getString("TRS_EXP"));
				warn.setTable(rs.getString("TRS_TABLE"));
				warn.setOption(rs.getInt("TRS_OPTION"));
				warn.setSynonym(rs.getString("TRS_SYNONYM"));
				warn.setCount(rs.getLong("TRS_COUNT"));
				warnList.add(warn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataAccess.Close(null, stmt, rs);
		}
		System.out.println("count：" + warnList.size());
		int i = 0 ;
		SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
		for (UserExpWarn warn : warnList) {
//			InputStream l_urlStream;
			if(i % 50 == 0 || i==warnList.size()-1) {
				System.out.println("已处理：" +  (i+1));
			}
			String timewhere = "";
			String fromtime = "";
			String endtime = "";
			try {
				if (warn.getUpdateDate() != null) {
					fromtime = s1.format(warn.getUpdateDate());
				} else {
					fromtime = s1.format(warn.getCreateDate());
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
			
			timewhere = "(" + warn.getExp() + ") and (公开（公告）日>('" + fromtime + "') and 公开（公告）日<=('" + endtime +"'))";
			timewhere = new GetSearchFormat().preprocess(timewhere);
//			if (warn.getUuid().equals("ED4EC04BDDAE09E3E040A8C06F08105E")) {
//				System.out.println(timewhere);
//			}
			long newcount = 0;
			TRSConnection trsConnection = Util.getConnect();
			if (trsConnection != null) {
				TRSResultSet trsresultset = null;
				
				try {
					if (warn.getSynonym() != null && !warn.getSynonym().equals("")) {
						trsConnection.setAutoExtend("", "", "", TRSConstant.TCM_KAXST);
					}
					
					trsresultset = trsConnection.executeSelect(warn.getTable(), timewhere,
							"", "", "", warn.getOption(), 115,
							false);
					
					if (trsresultset != null) {
						newcount = trsresultset.getRecordCount();
					}
				} catch (Exception e) {
					newcount = 0;
				} finally {
					Util.Close(trsConnection, trsresultset);
				}
				
			}
//			if (warn.getUuid().equals("ED4EC04BDDAE09E3E040A8C06F08105E")) {
//				System.out.println(newcount);
//			}
			
			if (newcount > 0) {
				
				long totalcount = 0;
				TRSResultSet trsresultset = null;
				try {
					if (warn.getSynonym() != null && !warn.getSynonym().equals("")) {
						trsConnection.setAutoExtend("", "", "", TRSConstant.TCM_KAXST);
					}
					trsresultset = trsConnection.executeSelect(warn.getTable(), new GetSearchFormat().preprocess(warn.getExp()),
							"", "", "", warn.getOption(), 115,
							false);
					
					if (trsresultset != null) {
						totalcount = trsresultset.getRecordCount();
					}
				} catch (Exception e) {
					e.printStackTrace();
					totalcount = 0;
				} finally {
					if (trsresultset != null) {
						try {
							trsresultset.close();
						} catch (Exception exception) {
						}
					}

					if (trsConnection != null) {
						try {
							trsConnection.close();
						} catch (Exception exception) {
						}
					}
				}
				System.out.println("添加预警历史：" + warn.getUuid());
				PreparedStatement stmt1 = null;
				try {
					stmt1 = (PreparedStatement) conn
							.prepareStatement("update app_tb_user_exp_warn t set t.TRS_COUNT=" + totalcount +
									", t.UPDATE_DATE=str_to_date(date_format(sysdate(),'%Y-%m-%d %H:%i:%S'), '%Y-%m-%d %H:%i:%S') where t.uuid='" + warn.getUuid() + "'");
					
//					if (warn.getUuid().equals("ED4EC04BDDAE09E3E040A8C06F08105E")) {
//						System.out.println("update app_tb_user_exp_warn t set t.TRS_COUNT=" + totalcount +
//								", t.UPDATE_DATE=to_date(to_char(sysdate,'yyyy-MM-dd hh:mi:ss'), 'yyyy-MM-dd hh:mi:ss') where t.uuid='" + warn.getUuid() + "'");
//					}
					stmt1.executeUpdate();
					
					stmt1 = (PreparedStatement) conn
							.prepareStatement("insert into app_tb_user_exp_warn_his(uuid, WARN_UUID, USERNAME, TRS_TABLE, TRS_OPTION, TRS_SYNONYM, TRS_COUNT, WARN_DATE, TRS_EXP, STATE) " +
									"values(?,?,?,?,?,?,?,?,?,?)");
//					if (warn.getUuid().equals("ED4EC04BDDAE09E3E040A8C06F08105E")) {
//						System.out.println("insert into app_tb_user_exp_warn_his(uuid, WARN_UUID, USERNAME, TRS_TABLE, TRS_OPTION, TRS_SYNONYM, TRS_COUNT, WARN_DATE, TRS_EXP, STATE) " +
//								"values(?,?,?,?,?,?,?,?,?)");
//					}
					stmt1.setString(1, UUID.randomUUID().toString());
					stmt1.setString(2, warn.getUuid());
					stmt1.setString(3, warn.getUsername());
					stmt1.setString(4, warn.getTable());
					stmt1.setInt(5, warn.getOption());
					stmt1.setString(6, warn.getSynonym());
					stmt1.setLong(7, newcount);
					
//					SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					stmt1.setDate(8, new java.sql.Date(new java.util.Date().getTime()));
					stmt1.setString(9, timewhere);
					stmt1.setInt(10, 0);
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
		new TimewarnTask().execute();
	}

}
