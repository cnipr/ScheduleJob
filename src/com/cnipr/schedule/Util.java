package com.cnipr.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import oracle.sql.CLOB;

import com.eprobiti.trs.TRSConnection;
import com.eprobiti.trs.TRSException;
import com.eprobiti.trs.TRSResultSet;

public class Util {
	
	public static TRSConnection getConnect() {
		TRSConnection trsConnection = null;
			try {
				trsConnection = new TRSConnection();
				trsConnection.connect(DataAccess.getProperty("TRSHost"),
						DataAccess.getProperty("TRSPort"), DataAccess.getProperty("TRSUserName"),
						DataAccess.getProperty("TRSPasswd"));
			} catch (TRSException e) {
				e.printStackTrace();
				trsConnection = null;
			}
		return trsConnection;
	}
	
	public String ClobToString(CLOB clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		br.close();
		is.close();
		return reString;
	}
	
	public static void Close(TRSConnection trsConnection, TRSResultSet trsresultset) {
			try {
				if (trsresultset != null) {
					trsresultset.close();
				}				
				if (trsConnection != null) {
						trsConnection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
			}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
