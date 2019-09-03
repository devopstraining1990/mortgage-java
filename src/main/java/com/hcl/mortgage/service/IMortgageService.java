package com.hcl.mortgage.service;

import com.hcl.mortgage.dto.MortgageDetailsDto;
import com.hcl.mortgage.dto.MortgageDto;

public interface IMortgageService {
	public MortgageDetailsDto signup(MortgageDto mortgageDto);
}