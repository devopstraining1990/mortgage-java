package com.hcl.mortgage.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderTest {
	
	@InjectMocks EmailSender emailSender;
	
	@Mock
	JavaMailSender mailSender;
	

	@Test
	public void testSendOtp() {
//		emailSender.sendOtp("sairam.cse6@gmail.com", "sample", "message");
//	Mockito.doNothing().when(mailSender.createMimeMessage());
		emailSender.sendOtp("sairam.cse6@gmail.com", "sample", "message");
	}

}
