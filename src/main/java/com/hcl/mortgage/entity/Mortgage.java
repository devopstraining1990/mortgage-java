package com.hcl.mortgage.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Mortgage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mortgageId;
	private String operationType;
	private Double propertyCost;
	private Double deposit;
	private String employmentStatus;
	private String occupation;
	
	private String title;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Long phoneNumber;
	private String email;
	private Integer customerId;
}
