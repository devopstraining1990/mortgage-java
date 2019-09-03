package com.hcl.mortgage.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.mortgage.dto.LoginDetailsDto;
import com.hcl.mortgage.dto.LoginDto;
import com.hcl.mortgage.service.UserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	LoginDetailsDto loginDetails = null;
	LoginDto loginDto = null;

	@Before
	public void setup() {

		loginDetails = new LoginDetailsDto();
		loginDetails.setStatusCode(200);

		loginDto = new LoginDto();
		loginDto.setLoginId("mpl@gmail.com");

	}

	@Test
	public void loginTest() {
		Mockito.when(userService.login(loginDto)).thenReturn(loginDetails);
		ResponseEntity<LoginDetailsDto> responseEntity = userController.login(loginDto);
		LoginDetailsDto loginDetailsDto = responseEntity.getBody();
		assertEquals(loginDetails.toString(), loginDetailsDto.toString());
	}

}
