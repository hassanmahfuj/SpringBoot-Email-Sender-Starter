package com.hum.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

	@Autowired
	JavaMailSender mailer;

	public boolean sendEmail(String to, String subject, String body) {
		SimpleMailMessage m = new SimpleMailMessage();
		m.setFrom("humarchive1@gmail.com");
		m.setTo(to);
		m.setSubject(subject);
		m.setText(body);

		mailer.send(m);
		return true;
	}
	
	public boolean sendContentEmail(String to, String subject, String body) {
		MimeMessage m = mailer.createMimeMessage();
		try {
			m.setFrom("humarchive1@gmail.com");
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
			m.setSubject(subject);
			m.setContent(body, "text/html");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailer.send(m);
		return true;
	}
}
