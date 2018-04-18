package com.cnipr.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClearAsDB
 */
@WebServlet(name = "clearasdb", urlPatterns = { "/clearasdb" })
public class ClearAsDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearAsDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进如删除临时物理库任务。。。。。。");
		List<String> aidList = new ArrayList<String>();
		Connection conn = DataAccess.getOracleConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = (PreparedStatement) conn
					.prepareStatement("select * from biz_tb_as_aid t where t.dbtype='A' and t.createtime<to_date(to_char(sysdate,'dd-MM-yyyy'), 'dd-mm-yyyy')");
			rs = stmt.executeQuery();
			while (rs.next()) {
				aidList.add(rs.getString("aid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataAccess.Close(conn, stmt, rs);
		}
		System.out.println("预备删除物理库：" + aidList.size());
		int i = 0 ;
		for (String aid : aidList) {
			String sCurrentLine = "";
			InputStream l_urlStream;
			
			if(i % 100 == 0) {
				System.out.println("已处理：" + i);
			}
			
			try{	
				URL l_url = new URL(DataAccess.getProperty("biz"));
				HttpURLConnection l_connection = (HttpURLConnection) l_url
					.openConnection();
				l_connection.setRequestMethod("POST");
//				l_connection.setRequestMethod("post");
				
				l_connection.setDoOutput(true);// 是否输入参数

		        StringBuffer params = new StringBuffer();
		        // 表单参数与get形式一样
		        params.append("aid").append("=").append(aid);
		        byte[] bypes = params.toString().getBytes();
		        l_connection.getOutputStream().write(bypes);// 输入参数
				
				l_urlStream = l_connection.getInputStream();
					
				BufferedReader l_reader = new BufferedReader(
						new InputStreamReader(l_urlStream, "utf-8"));
				while ((sCurrentLine = l_reader.readLine()) != null) {
					if (!sCurrentLine.contains("\"returnCode\":0")) {
						System.out.println(aid + ":" + sCurrentLine);
					}
				}
				l_connection.disconnect();
			}catch (MalformedURLException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			i++;
		}
		System.out.println("删除完毕");
	}
	
	public static void main(String[] args) {
		try {
			new ClearAsDB().doPost(null, null);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
