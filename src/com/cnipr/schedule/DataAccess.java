package com.cnipr.schedule;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * 
 * <p>
 * 鏍囬: DataAccess
 * </p>
 * <p>
 * 璇存槑: 璁块棶鏁版嵁搴撶殑鍩烘湰锟�/p>
 * <p>
 * 鐗堟潈: Copyright (c) 2004
 * </p>
 * <p>
 * 鍏徃: 鐭ヨ瘑浜ф潈鍑虹増锟�/p>
 * 
 * @wauthor
 * @wversion 1.0
 */

public class DataAccess {
	private static Properties _properties = null;
	
	/**
	 * @wfunction 璇诲彇閰嶇疆鏂囦欢
	 * @wparam key
	 * @wreturn
	 */
	public static String getProperty(String key) {

		if (_properties == null) {
			try {
				InputStream ins = DataAccess.class
						.getResourceAsStream("/app.properties");
				_properties = new Properties();
				_properties.load(ins);
			} catch (Exception ex) {
				_properties = null;
			}
		}

		return _properties.getProperty(key);
	}

	/**
	 * 鍒ゆ柇褰撳墠鏃ユ湡鏄槦鏈熷嚑<br>
	 * <br>
	 * 
	 * @param pTime
	 *            瑕佸垽鏂殑鏃堕棿<br>
	 * @return dayForWeek 鍒ゆ柇缁撴灉<br>
	 */
	public static int dayForWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}

	public static Date addDate(Date d, long day) throws ParseException {
		long time = d.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time += day;
		return new Date(time);
	}

	public static Date getDelay(int week) {
		Date rs = null;

		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 鍙互鏂逛究鍦颁慨鏀规棩鏈熸牸寮�
			String strnow = dateFormat.format(now);
			int weeknow;

			weeknow = DataAccess.dayForWeek(strnow);

			int days = week - weeknow;
			if (days < 0) {
				days = days + 7;
			}
			Date lastWed = addDate(now, days);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rs = sdf.parse(dateFormat.format(lastWed) + " 12:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static boolean IsStringNumber(String number) {

		if (number != null && number.length() > 0) {

			for (int i = 0; i < number.length(); i++) {
				char tempChar = number.charAt(i);
				if (tempChar < '0' || tempChar > '9') {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static String getCurrentTime() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = sy1.format(date);
		return currentTime;
	}

	public static String getStartTime() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyyMMddHHmmss");
		// date.setSeconds(date.getSeconds() - 5);
		String currentTime = sy1.format(date);
		return currentTime;
	}

	public static String getMsTime() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyyMMddHHmmssS");
		String currentTime = sy1.format(date);
		return currentTime;
	}

	// public static ConnectionPoolManager poolManager;
	// public static ConnectionPoolManager dsmsPoolManager;

	public static Connection getOracleConnection() {
		Connection conn = null;
		try {
				String driver = getProperty("Web.Oracle.Driver");
				String url = getProperty("Web.Oracle.URL");
				String user = getProperty("Web.Oracle.User");
				String password = getProperty("Web.Oracle.Password");

				StringUtils pwd = new StringUtils();
				pwd.setDesString(password); // 将要解密的密文传送给Encrypt.java进行解密计算。
				String M = pwd.getStrM();

				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, M);
//			if (conn == null || !testConnect()) {
//			}
		} catch (Exception e) {
			conn = null;
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return conn;
	}
	
	/*public static boolean testConnect(){
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement("select 1");
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1) == 1;
		} catch (Exception e) {
			return false;
		}finally{
			Close(preparedStatement, resultSet);
		}
	}*/
	
	
	/*public static void Close(PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// System.gc();
		}
	}*/


	public static void Close(Connection conn, PreparedStatement pstm,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// System.gc();
		}
	}

//	public static void Close(Connection conn, PreparedStatement pstm) {
//		try {
//			if (pstm != null) {
//				pstm.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn, CallableStatement cstm,
//			ResultSet rs) {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (cstm != null) {
//				cstm.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn, Statement stmt, ResultSet rs) {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn, CallableStatement cstm) {
//		try {
//			if (cstm != null) {
//				cstm.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn) {
//		try {
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn, PreparedStatement pstm,
//			CallableStatement cstm, ResultSet rs) {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (pstm != null) {
//				pstm.close();
//			}
//			if (cstm != null) {
//				cstm.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
//
//	public static void Close(Connection conn, PreparedStatement pstm1,
//			PreparedStatement pstm2, ResultSet rs) {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (pstm1 != null) {
//				pstm1.close();
//			}
//			if (pstm2 != null) {
//				pstm2.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// System.gc();
//		}
//	}
	
	public static void main(String[] args) {
		System.out.println(DriverManager.getLoginTimeout());
//		System.out.println(testConnect());
	}

}
