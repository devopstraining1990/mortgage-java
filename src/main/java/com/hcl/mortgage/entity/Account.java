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
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	private String accountNumber;
	private String accountType;
	private Double balance;
	private LocalDate createdDate;
	private Integer customerId;

}
