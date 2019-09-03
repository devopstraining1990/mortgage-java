package com.hcl.mortgage.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor

public class MortgageDto implements Serializable{
	
	private static final long serialVersionUID = 1469147933944989068L;
	
	private String operationType;
	private Double propertyCost;
	private Double deposit;
	private String employmentStatus;
	private String occupation;
	private Double salary;
	private String title;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Long phoneNumber;
	private String email;
}