package com.hcl.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.mortgage.dto.LastTrasactionResponseDto;
import com.hcl.mortgage.service.LastTopTransctionsImpl;


@CrossOrigin(allowedHeaders= {"*","*/"},origins= {"*","*/"})
@Controller
public class LastTopTransctionsContoller {
	
	@Autowired LastTopTransctionsImpl lastTopTransctionsImpl;
	
	
	
	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<List<LastTrasactionResponseDto>> lastTransactions(@PathVariable("accountNumber")String accountNumber) {
		return ResponseEntity.status(HttpStatus.OK).body(lastTopTransctionsImpl.lastTransactions(accountNumber));
	}

}
