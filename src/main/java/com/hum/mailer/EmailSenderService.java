package com.hum.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	JavaMailSender mailer;

	public boolean sendEmail(String to, String subject, String body) {
		SimpleMailMessage m = new SimpleMailMessage();
		m.setFrom("__@gmail.com");
		m.setTo(to);
		m.setSubject(subject);
		m.setText(body);

		mailer.send(m);
		return true;
	}
}
