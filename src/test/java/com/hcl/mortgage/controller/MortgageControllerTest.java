package com.hcl.mortgage.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.mortgage.dto.MortgageDetailsDto;
import com.hcl.mortgage.dto.MortgageDto;
import com.hcl.mortgage.service.IMortgageService;

@RunWith(MockitoJUnitRunner.class)
public class MortgageControllerTest {

	@Mock
	IMortgageService mortgageService;

	@InjectMocks
	MortgageController mortgageController;

	MortgageDto mortgageDto = null;
	MortgageDetailsDto mortgageDetailsDto = null;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(mortgageController).build();

	}

	@Test
	public void testSignup() throws Exception {
		mortgageDto = new MortgageDto();
		mortgageDto.setDeposit(10000000D);
		mortgageDto.setDob(LocalDate.now());
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
		
		Mockito.when(mortgageService.signup(mortgageDto)).thenReturn(mortgageDetailsDto);
		ResponseEntity<MortgageDetailsDto> responseEntity = mortgageController.signup(mortgageDto);
		MortgageDetailsDto mortgage = responseEntity.getBody();
		assertEquals(mortgageDetailsDto.getStatusCode(), mortgage.getStatusCode());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
