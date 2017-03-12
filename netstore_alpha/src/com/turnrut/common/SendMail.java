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
			// ����session and message
			Session session = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("8884087@163.com"));
			msg.setRecipients(Message.RecipientType.TO, c.getEmail());
			msg.setSubject("����XX�̳ǵļ����ʼ�");
			msg.setContent("�װ���"+c.getCusName()+"��ã�<br>&nbsp;&nbsp;��л��ע���ΪXX�̳ǻ�Ա�����ͻ��·����ӳ�Ϊ��ʽ��Ա<br>&nbsp;&nbsp;<a href='http://localhost:8080/netstore_alpha/Servlet/ClientServlet?op=cusActive&code="+c.getKeyCode()+"'>�������������Ҽ����˺š�������</a>", 
					"text/html;charset=UTF-8");
			msg.saveChanges();
			//����
			Transport ts = session.getTransport();
			ts.connect("8884087", "wqnmlgb8878715");
			ts.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
}
