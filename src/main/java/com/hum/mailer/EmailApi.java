package com.hum.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailApi {

	@Autowired
	EmailSenderService mailSender;

	@PostMapping("/mail")
	public boolean sendMail(@RequestBody SimpleMail simpleMail) {
		return mailSender.sendEmail(simpleMail.getTo(), simpleMail.getSubject(), simpleMail.getBody());
	}
}
