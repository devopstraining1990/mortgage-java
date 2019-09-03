package com.hcl.mortgage.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.LoginDetailsDto;
import com.hcl.mortgage.dto.LoginDto;
import com.hcl.mortgage.entity.Customer;
import com.hcl.parking.util.ParkingConstants;

/**
 * @author Lakshmi
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * This method is intended for registration of the user
	 * 
	 * @param UserDto
	 * @return UserDetailsDto
	 */

	/**
	 * This method is intended for login of the user
	 * 
	 * @param LoginDto
	 * @return LoginDetailsDto
	 */
	public LoginDetailsDto login(LoginDto loginDto) {
		LOGGER.debug("UserServiceImpl login()");
		LoginDetailsDto loginResponseDto = null;
		Base64.Encoder encoder = Base64.getEncoder();
		String password = encoder.encodeToString(loginDto.getPassword().getBytes());
		List<Customer> customer = customerRepository.findByLoginIdAndPassword(loginDto.getEmail(), password);
		if (users.isEmpty()) {
			loginResponseDto = new LoginDetailsDto();
			loginResponseDto.setStatusCode(401);
			loginResponseDto.setMessage(ParkingConstants.LOGIN_FAILURE);
		} else {
			

			loginResponseDto = new LoginDetailsDto();
			loginResponseDto.setUserId(user.getUserId());
			loginResponseDto.setUserName(user.getUserName());
			loginResponseDto.setRoleType(role.get().getRoleType());
			loginResponseDto.setStatusCode(200);
			loginResponseDto.setMessage(ParkingConstants.LOGIN_SUCCESS);

		}
		return loginResponseDto;
	}

	public int calculateAge(LocalDate birthDate) {
		LocalDate todayDate = LocalDate.now();
		Period p = Period.between(birthDate, todayDate);
		return p.getYears();

	}

}
