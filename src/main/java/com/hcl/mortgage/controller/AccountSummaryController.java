package com.hcl.mortgage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.AccountSummaryResponse;
import com.hcl.mortgage.service.AccountSummaryServiceImpl;

/**
 * @author Shiva
 * 
 * This class contains logic to get different account details
 * 
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class AccountSummaryController {

	private static final Logger logger = LoggerFactory.getLogger(AccountSummaryController.class);

	@Autowired
	AccountSummaryServiceImpl accountSummaryServiceImpl;
	
	/**
	 * @param Customer Id
	 * 
	 * 
	 * 
	 * This methods contains logic to get different account details like transaction account,mortgage account details
	 * 
	 *
	 */

	@GetMapping("/accountSummary/{customerId}")
	public ResponseEntity<List<AccountSummaryResponse>> getAccountSummaryDetails(@PathVariable Integer customerId) {

		logger.info("Inside AccountSummaryController customerId:{}", customerId);

		return new ResponseEntity<>(accountSummaryServiceImpl.accountSummary(customerId), HttpStatus.OK);

	}

}
