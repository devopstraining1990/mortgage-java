package com.hcl.mortgage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.AccountSummaryResponse;
import com.hcl.mortgage.exception.MortgageException;
import com.hcl.mortgage.repository.AccountRepository;

@Service
public class AccountSummaryServiceImpl implements AccountSummaryService {

	private static final Logger logger = LoggerFactory.getLogger(AccountSummaryServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<AccountSummaryResponse> accountSummary(Integer customerId) {

		logger.info("Inside AccountSummaryServiceImpl customerId:{}", customerId);

		List<AccountSummaryResponse> accountSummaryList = accountRepository.findByCustomerId(customerId);

		if (accountSummaryList != null) {
			return accountSummaryList;

		}

		else {

			throw new MortgageException("No Accounts For the given userId");

		}

	}

}
