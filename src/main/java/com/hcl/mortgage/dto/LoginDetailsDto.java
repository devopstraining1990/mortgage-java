package com.hcl.mortgage.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginDetailsDto implements Serializable{
	private static final long serialVersionUID = 1684378947215040319L;
	
	private Integer userId; 
	private String userName;
	private String message;
	private String roleType;
	private Integer statusCode;
}
