package com.turnrut.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.turnrut.domain.Customer;

public class SendMail extends Thread {
	private Customer c;
	
	public SendMail(Customer c) {
		this.c = c;
	}
	public void run(){
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.163.com");
			props.setProperty("mail.smtp.auth", "true");
			// 创建session and message
			Session session = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("8884087@163.com"));
			msg.setRecipients(Message.RecipientType.TO, c.getEmail());
			msg.setSubject("来自XX商城的激活邮件");
			msg.setContent("亲爱的"+c.getCusName()+"你好，<br>&nbsp;&nbsp;感谢您注册成为XX商城会员，请猛击下方链接成为正式会员<br>&nbsp;&nbsp;<a href='http://localhost:8080/netstore_alpha/Servlet/ClientServlet?op=cusActive&code="+c.getKeyCode()+"'>》》》》请点击我激活账号《《《《</a>", 
					"text/html;charset=UTF-8");
			msg.saveChanges();
			//发出
			Transport ts = session.getTransport();
			ts.connect("8884087", "wqnmlgb8878715");
			ts.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
}
