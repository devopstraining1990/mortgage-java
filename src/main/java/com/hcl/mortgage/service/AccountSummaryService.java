package com.hcl.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.AccountSummaryResponse;

@Service
public interface AccountSummaryService {
	
	public List<AccountSummaryResponse> accountSummary(Integer customerId);

}
