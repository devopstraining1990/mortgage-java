package com.hcl.mortgage.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderTest {
	
	@InjectMocks EmailSender emailSender;
	
	@Mock
	JavaMailSender mailSender;
	

}
