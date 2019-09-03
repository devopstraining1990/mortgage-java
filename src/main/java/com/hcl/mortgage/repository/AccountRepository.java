package com.hcl.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.mortgage.dto.AccountSummaryResponse;
import com.hcl.mortgage.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	
	public List<AccountSummaryResponse> findByCustomerId(Integer customerId);

	public Account findByCustomerIdAndAccountType(Integer customerId, String accountType);

}
