package com.hcl.mortgage.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountSummaryResponse {
	
	
	private Integer accountId;
	private Integer accountNumber;
	private Double balance;
	private String accountType;

}
