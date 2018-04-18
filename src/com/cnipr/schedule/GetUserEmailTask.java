package com.cnipr.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GetUserEmailTask {

	public static synchronized Map<String, String> execute(String pubDateStr)
			throws ParseException {
		Map<String, String> emailMap = new HashMap<String, String>();
		Connection conn = DataAccess.getOracleConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = (PreparedStatement) conn
					.prepareStatement("select distinct email from app_tb_user_exp_warn t1 left join app_tb_user t2 on t1.username = t2.username"
							+ " where to_days(update_date) = to_days( str_to_date('"
							+ pubDateStr
							+ "', '%Y%m%d')) and t2.email is not null and t2.email != '' ");
			rs = stmt.executeQuery();
			while (rs.next()) {
				emailMap.put(rs.getString("EMAIL"),
						"\tマイ定期アラート：http://www.cnipr.jp/?targetURL=warn!list.action\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataAccess.Close(null, stmt, rs);
		}

		try {
			stmt = (PreparedStatement) conn
					.prepareStatement("select distinct email from app_tb_user_legal_warn t1 left join app_tb_user t2 on t1.username = t2.username"
							+ " where to_days(latest_pub_date) = to_days( str_to_date('"
							+ pubDateStr
							+ "', '%Y%m%d')) and t2.email is not null and t2.email != '' ");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String email = rs.getString("EMAIL");
				emailMap.put(
						email,
						emailMap.get(email)
								+ "\t法律状態定期アラート：http://www.cnipr.jp?targetURL=warn!legal.action\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataAccess.Close(null, stmt, rs);
		}
		DataAccess.Close(conn, null, null);
		for (Iterator<Map.Entry<String, String>> iterator = emailMap.entrySet()
				.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			entry.setValue("CNIPR日本語版をご利用頂き、誠にありがとうございます。\r\n\r\n"
					+ "ご登録いただいた定期アラートの最新情報が更新されましたのでお知らせします。 \r\n"
					+ "下記のURLよりログインしご確認ください。\r\n\r\n\r\n "
					+ entry.getValue() 
					+ "\r\n\r\n\r\nよろしくお願い致します。");
		}
		return emailMap;
	}

	public static void main(String[] args) throws ParseException {
		Map<String, String> map = GetUserEmailTask.execute("20180206");
		for (Iterator<Map.Entry<String, String>> iterator = map.entrySet()
				.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "\r\n" + entry.getValue() + "\r\n\r\n");
		}
	}

}
