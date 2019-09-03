package com.hcl.mortgage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.LoginDetailsDto;
import com.hcl.mortgage.dto.LoginDto;
import com.hcl.mortgage.service.UserService;

/**
 * @author Lakshmi
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * This method is intended for login of the user
	 * 
	 * @param LoginDto
	 * @return LoginDetailsDto
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginDetailsDto> login(@RequestBody LoginDto loginDto) {
		LOGGER.debug("PurchasePolicyController login()");
		LoginDetailsDto loginDetailsDto = userService.login(loginDto);
		return new ResponseEntity<>(loginDetailsDto, HttpStatus.OK);
	}

}
