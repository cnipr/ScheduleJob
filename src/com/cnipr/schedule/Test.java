package com.cnipr.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Connection conn1 = DataAccess.getOracleConnection();;
		PreparedStatement stmt1 = conn1.prepareStatement("select count(*) from app_tb_user_exp_warn_his " +
				"where WARN_UUID= ? and date_format(warn_date,'%Y%m%d')=?");
//		stmt1.setString(1, "6a175b75-d7b3-11e2-88cf-a29e311bf375");
		stmt1.setString(1, "8909e648-d730-11e2-88cf-a29e311bf375");
		stmt1.setString(2, "20141011");
		ResultSet rs2 = stmt1.executeQuery();
		rs2.next();
		int count = rs2.getInt(1);
		System.out.println(count);
		rs2.close();
		stmt1.close();
		conn1.close();

	}

}
