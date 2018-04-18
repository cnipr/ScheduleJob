package com.cnipr.schedule;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SingleMailSend {
	public static void main(String args[]) {
		String to = "weiding@cnipr.com";
//		to = "1141950789@qq.com";
		String title = "Cnipr法律状态预警utf8";
		String content = "utf8编码   http://www.cnipr.jp?targetURL=warn!legal.action           http://localhost:8080/cnipr-vol1/?targetURL=warn!legal.action";
		boolean result = mailFromCnipr263(to, title, content);
		System.out.println(result);
	}

	public static boolean mailFromCnipr263(String to, String title,
			String content) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.263xmail.com");
		senderImpl.setUsername("jpcnipr_service@cnipr.com");
		senderImpl.setPassword("cnipr2013");
		
		Properties prop = new Properties();
		prop.put(" mail.smtp.auth ", " true ");
		prop.put(" mail.smtp.timeout ", " 25000 ");
		//默认是25端口,本质公司的服务器指定了587端口
		prop.put("mail.smtp.port", "587");
		senderImpl.setJavaMailProperties(prop);
		
		MimeMessage message = senderImpl.createMimeMessage();  
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");  
			helper.setTo(to);
			helper.setFrom("jpcnipr_service@cnipr.com");
			helper.setSubject(title);
			helper.setText(content);
			senderImpl.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean mailFromCnipr263_bak(String to, String title,
			String content) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.263xmail.com");
		senderImpl.setUsername("jpcnipr_service@cnipr.com");
		senderImpl.setPassword("cnipr2013");

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("jpcnipr_service@cnipr.com");
		mailMessage.setSubject(title);
		mailMessage.setText(content);

		Properties prop = new Properties();
		prop.put(" mail.smtp.auth ", " true ");
		prop.put(" mail.smtp.timeout ", " 25000 ");
		prop.put("mail.smtp.port", "587");
		senderImpl.setJavaMailProperties(prop);
		try {
			senderImpl.send(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean mailFromYahoo(String to, String title,
			String content) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		senderImpl.setHost("smtp.mail.yahoo.co.jp");
		senderImpl.setUsername("jpcnipr@yahoo.co.jp");
		senderImpl.setPassword("Ipph_123456");

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("jpcnipr@yahoo.co.jp");
		mailMessage.setSubject(title);
		mailMessage.setText(content);

		Properties prop = new Properties();
		prop.put(" mail.smtp.auth ", " true ");
		prop.put(" mail.smtp.timeout ", " 25000 ");
		prop.put("mail.smtp.port", "465");
		senderImpl.setJavaMailProperties(prop);
		try {
			senderImpl.send(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
