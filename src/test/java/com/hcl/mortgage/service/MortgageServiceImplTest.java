package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

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

import com.hcl.mortgage.dto.MortgageDetailsDto;
import com.hcl.mortgage.dto.MortgageDto;
import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.entity.Mortgage;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.exception.MortgageException;
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
	

	

	MortgageDto mortgageDto = null;
	MortgageDetailsDto mortgageDetailsDto = null;
	Mortgage mortgage = null;
	Customer customer = null;
	
	
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
		account.setCustomerId(1);

		transaction = new Transaction();
		transaction.setTransactionId(1);

		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(emailSender.sendOtp(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Mockito.anyString());
		MortgageDetailsDto mortgage = mortgageServiceImpl.signup(mortgageDto);
		assertEquals(mortgageDetailsDto.getStatusCode(), mortgage.getStatusCode());
	}

	@Test(expected = MortgageException.class)
	public void testSignupAge() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.of(2019, 06, 18));
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
		mortgage.setDob(LocalDate.of(2019, 06, 18));

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

		mortgageServiceImpl.signup(mortgageDto);

	}

	@Test(expected = MortgageException.class)
	public void testSignupEmail() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.of(2019, 06, 18));
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
		mortgage.setEmail("mpl.com");
		mortgage.setDob(LocalDate.of(2019, 06, 18));

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

		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

		mortgageServiceImpl.signup(mortgageDto);

	}
	
	@Test(expected = MortgageException.class)
	public void testSignupPhone() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.of(2019, 06, 18));
		mortgageDto.setEmail("raja@gmail.com");
		mortgageDto.setEmploymentStatus("employee");
		mortgageDto.setFirstName("raja");
		mortgageDto.setLastName("kumar");
		mortgageDto.setOccupation("professional");
		mortgageDto.setPhoneNumber(9030812L);
		mortgageDto.setPropertyCost(100000D);
		mortgageDto.setSalary(300000D);
		mortgageDto.setTitle("Mr.");

		mortgageDetailsDto = new MortgageDetailsDto();
		mortgageDetailsDto.setStatusCode(201);

		mortgage = new Mortgage();
		mortgage.setEmail("mpl@gmail.com");
		mortgage.setDob(LocalDate.of(2019, 06, 18));

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

		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

		mortgageServiceImpl.signup(mortgageDto);

	}
	
	@Test(expected = MortgageException.class)
	public void testSignupProperty() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.of(2019, 06, 18));
		mortgageDto.setEmail("raja@gmail.com");
		mortgageDto.setEmploymentStatus("employee");
		mortgageDto.setFirstName("raja");
		mortgageDto.setLastName("kumar");
		mortgageDto.setOccupation("professional");
		mortgageDto.setPhoneNumber(9030853212L);
		mortgageDto.setPropertyCost(100D);
		mortgageDto.setSalary(300000D);
		mortgageDto.setTitle("Mr.");

		mortgageDetailsDto = new MortgageDetailsDto();
		mortgageDetailsDto.setStatusCode(201);

		mortgage = new Mortgage();
		mortgage.setEmail("mpl.com");
		mortgage.setDob(LocalDate.of(2019, 06, 18));

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

		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

		mortgageServiceImpl.signup(mortgageDto);

	}
}
