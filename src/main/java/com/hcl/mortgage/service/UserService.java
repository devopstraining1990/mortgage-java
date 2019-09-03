package com.hcl.mortgage.service;

import com.hcl.mortgage.dto.LoginDetailsDto;
import com.hcl.mortgage.dto.LoginDto;


public interface UserService {

	public LoginDetailsDto login(LoginDto loginDto);

}
