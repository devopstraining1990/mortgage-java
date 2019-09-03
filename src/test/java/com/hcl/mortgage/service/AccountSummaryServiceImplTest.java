package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.AccountSummaryResponse;
import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.exception.MortgageException;
import com.hcl.mortgage.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountSummaryServiceImplTest {

	@Mock
	AccountRepository accountRepository;

	@InjectMocks
	AccountSummaryServiceImpl accountSummaryServiceImpl;

	@Test
	public void testAccountSummary() {

		List<Account> accountsList = new ArrayList<>();
		Account account = new Account();
		account.setAccountId(1);
		account.setAccountNumber("MORT1234");
		account.setAccountType("Transaction account");
		account.setBalance(1000000D);
		account.setCreatedDate(LocalDate.now());
		account.setCustomerId(1);

		accountsList.add(account);

		Account account2 = new Account();
		account2.setAccountId(1);
		account2.setAccountNumber("MORT1234");
		account2.setAccountType("Mortgage account");
		account2.setBalance(1000000D);
		account2.setCreatedDate(LocalDate.now());
		account2.setCustomerId(2);
		accountsList.add(account2);

		List<AccountSummaryResponse> accountSummaryResponseList = new ArrayList<>();

		AccountSummaryResponse accountSummaryResponse = new AccountSummaryResponse();
		accountSummaryResponse.setAccountId(1);
		accountSummaryResponse.setAccountNumber("MORT1234");
		accountSummaryResponse.setAccountType("Mortgage Account");
		accountSummaryResponse.setBalance(1000000D);
		accountSummaryResponseList.add(accountSummaryResponse);

		AccountSummaryResponse accountSummaryResponse2 = new AccountSummaryResponse();
		accountSummaryResponse2.setAccountId(1);
		accountSummaryResponse2.setAccountNumber("MORT1234");
		accountSummaryResponse2.setAccountType("Mortgage Account");
		accountSummaryResponse2.setBalance(1000000D);
		accountSummaryResponseList.add(accountSummaryResponse2);

		Mockito.when(accountRepository.findByCustomerId(Mockito.anyInt())).thenReturn(accountsList);

		Customer customer = new Customer();
		customer.setCustomerId(1);

		List<AccountSummaryResponse> actualValue = accountSummaryServiceImpl.accountSummary(customer.getCustomerId());
		assertEquals(accountSummaryResponseList.size(), actualValue.size());

	}

	@Test(expected = MortgageException.class)
	public void testAccountSummaryElse() {

		List<Account> accountsList = new ArrayList<>();
		Account account = new Account();
		account.setAccountId(1);
		account.setAccountNumber("MORT1234");
		account.setAccountType("Transaction account");
		account.setBalance(1000000D);
		account.setCreatedDate(LocalDate.now());
		account.setCustomerId(1);

		accountsList.add(account);

		Account account2 = new Account();
		account2.setAccountId(1);
		account2.setAccountNumber("MORT1234");
		account2.setAccountType("Mortgage account");
		account2.setBalance(1000000D);
		account2.setCreatedDate(LocalDate.now());
		account2.setCustomerId(2);
		accountsList.add(account2);

		List<AccountSummaryResponse> accountSummaryResponseList = new ArrayList<>();

		AccountSummaryResponse accountSummaryResponse = new AccountSummaryResponse();
		accountSummaryResponse.setAccountId(1);
		accountSummaryResponse.setAccountNumber("MORT1234");
		accountSummaryResponse.setAccountType("Mortgage Account");
		accountSummaryResponse.setBalance(1000000D);
		accountSummaryResponseList.add(accountSummaryResponse);

		AccountSummaryResponse accountSummaryResponse2 = new AccountSummaryResponse();
		accountSummaryResponse2.setAccountId(1);
		accountSummaryResponse2.setAccountNumber("MORT1234");
		accountSummaryResponse2.setAccountType("Mortgage Account");
		accountSummaryResponse2.setBalance(1000000D);
		accountSummaryResponseList.add(accountSummaryResponse2);

		// Mockito.when(accountRepository.findByCustomerId(Mockito.anyInt())).thenReturn(accountsList);

		Customer customer = new Customer();
		customer.setCustomerId(1);

		accountSummaryServiceImpl.accountSummary(customer.getCustomerId());

	}

}
