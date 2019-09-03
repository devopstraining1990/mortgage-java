package com.hcl.mortgage.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.mortgage.service.AccountSummaryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountSummaryControllerTest {

	@Mock
	AccountSummaryServiceImpl accountSummaryServiceImpl;

	@InjectMocks
	AccountSummaryController accountSummaryController;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(accountSummaryController).build();
	}

	@Test
	public void testGetAccountSummaryDetails() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/accountSummary/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL))
				.andExpect(status().isOk());
	}

}
