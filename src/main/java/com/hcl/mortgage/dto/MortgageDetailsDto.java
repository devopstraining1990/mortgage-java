package com.hcl.mortgage.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MortgageDetailsDto implements Serializable{

	private static final long serialVersionUID = 915239200299978935L;
	
	private String transactionAccountNumber;
	private String mortgageAccountNumber;
	private String loginId;
	private String password;
	private Integer statusCode;
	private String message;

}
