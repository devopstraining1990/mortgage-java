package com.hcl.mortgage.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class LastTrasactionResponseDto {
	
	String accountNumber;
	LocalDateTime transactionDate;
	String transactionType;
	Double amount;
	String decription;

}
