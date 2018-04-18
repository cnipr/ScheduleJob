package com.cnipr.schedule;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClearAsDB
 */
public class Timewarn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Timer trstimer = new Timer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timewarn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 自动预警
	 */
	public void init(ServletConfig config) throws ServletException {
//		new Thread(new TimewarnTask()).start();
		new Thread(new LegalwarnTask()).start();
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
	 * 通过手动触发的方式进行预警
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		new TimewarnTask().execute();
		new LegalwarnTask().execute();
	}
	
	public void contextDestroyed(ServletContextEvent event) { 
		trstimer.cancel(); 
		System.out.println("===destroy==="); 
	} 

	
	public static void main(String[] args) {
		try {
			new Timewarn().doPost(null, null);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
