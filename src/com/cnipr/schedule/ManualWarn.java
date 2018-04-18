package com.cnipr.schedule;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClearAsDB
 */
public class ManualWarn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//用来记录那些用户已经发送过邮件
	public static Set<String> emailSet = new HashSet<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManualWarn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig) 自动预警
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 通过手动触发的方式进行预警
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String pubDateStr = request.getParameter("pubDate");
		if (pubDateStr == null) {
			out.write("参数pubDate不可以为空,正确的格式如：20160504.".getBytes());
			return;
		}
		try {
			System.out.println("===ManualWarn:" + pubDateStr);
			ManualWarnTask.execute(pubDateStr);
			System.out.println("===ManualWarn end=========");
			System.out.println("===ManualLegalWarn:" + pubDateStr);
			ManualLegalTask.execute(pubDateStr);
			System.out.println("===ManualLegalWarn end=========");
			Map<String, String> mailMap = GetUserEmailTask.execute(pubDateStr);
			System.out.println("===GetUserMail end=========");
			for (Iterator<Map.Entry<String, String>> iterator = mailMap
					.entrySet().iterator(); iterator.hasNext();) {
				Entry<String, String> entry = iterator.next();
				System.out.println(entry.getKey() + entry.getValue());
				
				 /*if (!entry.getKey().equals("weiding@cnipr.com")) { 
					 continue;
				 }*/
				
				if (emailSet.contains(entry.getKey())) {//已经发送过的不再发送
					continue;
				}
				 
				SingleMailSend.mailFromCnipr263(entry.getKey(),
						"CNIPR日本語版定期アラート結果【"+ pubDateStr +"】" ,
						entry.getValue());				
				emailSet.add(entry.getKey());
			}
			System.out.println("===SendMail end=========");
			out.write("success".getBytes());
			
		} catch (ParseException e) {
			out.write("参数pubDate日期格式不正确,正确的格式如：20160504.".getBytes());
		} finally {
			out.close();
		}

	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("===destroy===");
	}

	public static void main(String[] args) throws Exception {
		/*
		 * try { new ManualWarn().doPost(null, null); } catch (ServletException
		 * e) { e.printStackTrace(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		// http://localhost:8080/ScheduleJob/manualWarn?pubDate=20170630

	}

	private boolean isWednesday(String str) throws ParseException {
		SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
		Date pubDate = s1.parse(str);
		Calendar cal = Calendar.getInstance();
		cal.setTime(pubDate);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return week == 3;
	}

}
