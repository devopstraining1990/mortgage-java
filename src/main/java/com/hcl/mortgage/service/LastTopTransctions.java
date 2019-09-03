package com.hcl.mortgage.service;

import java.util.List;

import com.hcl.mortgage.dto.LastTrasactionResponseDto;

public interface LastTopTransctions {
	
	public List<LastTrasactionResponseDto> lastTransactions(String accountNumber);

}
