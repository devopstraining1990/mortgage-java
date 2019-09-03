package com.hcl.mortgage.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

	private JavaMailSender javaMailSender;

	
	@Autowired
	public EmailSender(JavaMailSender javaMailSender) {
	 this.javaMailSender = javaMailSender;
	}

	public String sendOtp(String mailId, String headMessage, String bodyMessage) {

		LOGGER.info("Enter send mail");

		String returnString = "Email sent sucess";
		try {

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(mailId);
			helper.setSubject(headMessage);
			helper.setText(bodyMessage);
 
			javaMailSender.send(message); 

		} catch (Exception e) {
			returnString = "Mail failed";
			LOGGER.error(e.getMessage());
		}
		return returnString;

	}
	
	
}
