package com.hcl.mortgage.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String accountNumber;
	private LocalDateTime transactionDate;
	private String transactionType;
	private Double amount;
	private String description;

}
