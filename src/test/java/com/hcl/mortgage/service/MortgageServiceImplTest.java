package com.hcl.mortgage.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.repository.AccountRepository;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.repository.MortgageRepository;
import com.hcl.mortgage.repository.TransactionRepository;


@RunWith(MockitoJUnitRunner.class)
public class MortgageServiceImplTest {
	
	
	@InjectMocks MortgageServiceImpl mortgageServiceImpl;
	
	@Mock
	MortgageRepository mortgageRepository;

	@Mock
	CustomerRepository customerRepository;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransactionRepository transactionRepository;
	
	@Mock
	EmailSender emailSender;

	Transaction transaction;
	List<Transaction> transactionList;

	Transaction transaction2;
	Account account;
	Account account2;
	
	List<Account> accountList;
	@org.junit.Before
	public void setUp() {
		transaction=new Transaction();
		transaction.setAccountNumber("1");
		transaction.setAmount(1000d);
		transaction.setDescription("discription");
		transaction.setTransactionId(1);
		transaction.setTransactionType("debit");
		
		
		transaction2=new Transaction();
		transaction2.setAccountNumber("1");
		transaction2.setAmount(1000d);
		transaction2.setDescription("discription");
		transaction2.setTransactionId(1);
		transaction2.setTransactionType("debit");
		
		transactionList=new ArrayList<>();
		transactionList.add(transaction2);
		
		
		account=new Account();
		account.setAccountId(1);
		account.setAccountNumber(transaction.getAccountNumber());
		account.setAccountType("mortgage");
		account.setBalance(1000d);
		account.setCreatedDate(LocalDate.now());
		account.setCustomerId(1);
		
		account2=new Account();
		account2.setAccountId(1);
		account2.setAccountNumber(transaction.getAccountNumber());
		account2.setAccountType("mortgage");
		account2.setBalance(1000d);
		account2.setCreatedDate(LocalDate.now());
		account2.setCustomerId(1);
		
		
		accountList=new ArrayList<>();
		accountList.add(account);
		accountList.add(account2);
		
	}
	
	
	@Test
	public void batchProcess() {
		
		Mockito.when(accountRepository.findByCustomerIdAndAccountType(Mockito.anyInt(), Mockito.any())).thenReturn(account);

		Mockito.when(accountRepository.findAll()).thenReturn(accountList);
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(accountRepository.save(account2)).thenReturn(account2);
		
		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);
		Mockito.when(transactionRepository.save(transaction2)).thenReturn(transaction2);
		
		String actual = mortgageServiceImpl.batchProcess();
		
		Assert.assertEquals("Monthly Batch Updated Successfully.", actual);

	}

	@Test
	public void batchProcess2() {
		
		account2.setBalance(-1000d);
		account.setBalance(-1000d);

		Mockito.when(accountRepository.findByCustomerIdAndAccountType(Mockito.anyInt(), Mockito.any())).thenReturn(account);

		Mockito.when(accountRepository.findAll()).thenReturn(accountList);
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(accountRepository.save(account2)).thenReturn(account2);
		
		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);
		Mockito.when(transactionRepository.save(transaction2)).thenReturn(transaction2);
		
		String actual = mortgageServiceImpl.batchProcess();
		
		Assert.assertEquals("Monthly Batch Updated Successfully.", actual);

	}

}
