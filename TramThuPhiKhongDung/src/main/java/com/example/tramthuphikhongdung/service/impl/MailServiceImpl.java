package com.example.tramthuphikhongdung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	//gửi mail	
	@Override
	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("manh1357904@gmail.com");
		message.setText(body);
		message.setTo(toEmail);
		message.setSubject(subject);
		mailSender.send(message);
	}

}
