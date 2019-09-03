package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.LoginDetailsDto;
import com.hcl.mortgage.dto.LoginDto;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	public void testLogin() {
		LoginDto loginDto = new LoginDto();
		loginDto.setLoginId("raja@gmail.com");
		loginDto.setPassword("raja@123");

		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		loginResponseDto.setMessage("");
		loginResponseDto.setStatusCode(200);

		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("raja");
		customer.setLoginId("raja@gmail.com");
		customer.setPassword("raja@123");
		customers.add(customer);
		Mockito.when(customerRepository.findByLoginIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customers);

		LoginDetailsDto actualValue = userServiceImpl.login(loginDto);
		assertEquals(loginResponseDto.getStatusCode(), actualValue.getStatusCode());

	}

	@Test
	public void testLoginFailure() {
		LoginDto loginDto = new LoginDto();
		loginDto.setLoginId("raja@gmail.com");
		loginDto.setPassword("raja@123");

		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		loginResponseDto.setMessage("");
		loginResponseDto.setStatusCode(401);

		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("raja");
		customer.setLoginId("raja@gmail.com");
		customer.setPassword("raja@123");

		Mockito.when(customerRepository.findByLoginIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customers);

		LoginDetailsDto actualValue = userServiceImpl.login(loginDto);
		assertEquals(loginResponseDto.getStatusCode(), actualValue.getStatusCode());

	}

}
