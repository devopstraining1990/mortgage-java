package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.MortgageDetailsDto;
import com.hcl.mortgage.dto.MortgageDto;
import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.entity.Mortgage;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.repository.AccountRepository;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.repository.MortgageRepository;
import com.hcl.mortgage.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class MortgageServiceImplTest {

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
	
	@InjectMocks
	MortgageServiceImpl mortgageService;
	
	
	MortgageDto mortgageDto = null;
	MortgageDetailsDto mortgageDetailsDto = null;
	Mortgage mortgage = null;
	Customer customer = null;
	Account account = null;
	Transaction transaction = null;
	
	@Test
	public void testSignup() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.of(1991, 06, 18));
		mortgageDto.setEmail("raja@gmail.com");
		mortgageDto.setEmploymentStatus("employee");
		mortgageDto.setFirstName("raja");
		mortgageDto.setLastName("kumar");
		mortgageDto.setOccupation("professional");
		mortgageDto.setPhoneNumber(9030853212L);
		mortgageDto.setPropertyCost(100000D);
		mortgageDto.setSalary(300000D);
		mortgageDto.setTitle("Mr.");
		
		mortgageDetailsDto = new MortgageDetailsDto();
		mortgageDetailsDto.setStatusCode(201);
		
		mortgage = new Mortgage();
		mortgage.setEmail("mpl@gmail.com");
		mortgage.setDob(LocalDate.of(1991, 06, 18));
		
		customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Lakshmi123");
		customer.setLoginId("Lakshmi123");
		customer.setPassword("Lakshmi@123");
		
		account = new Account();
		account.setAccountNumber("ACC123");
		account.setCustomerId(Mockito.anyInt());
		
		transaction = new Transaction();
		transaction.setTransactionId(1);
		
		Mockito.when(mortgageRepository.save(mortgage)).thenReturn(mortgage);
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);
		Mockito.when(emailSender.sendOtp(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Mockito.anyString());
		MortgageDetailsDto mortgage = mortgageService.signup(mortgageDto);
		assertEquals(mortgageDetailsDto.getStatusCode(), mortgage.getStatusCode());
	}

}
