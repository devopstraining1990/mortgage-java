package com.hcl.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.LastTrasactionResponseDto;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.repository.TransactionRepository;


@Service
public class LastTopTransctionsImpl implements LastTopTransctions {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<LastTrasactionResponseDto> lastTransactions(String accountNumber) {

		List<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber);

		List<LastTrasactionResponseDto> lastTrasactionResponseDtoList=new ArrayList<>();
		
		for (Transaction transaction : transactions) {
			
			LastTrasactionResponseDto lastTrasactionResponseDto = new LastTrasactionResponseDto();
			
			lastTrasactionResponseDto.setAccountNumber(transaction.getAccountNumber());
			lastTrasactionResponseDto.setAmount(transaction.getAmount());
			lastTrasactionResponseDto.setDecription(transaction.getDescription());
			lastTrasactionResponseDto.setTransactionDate(transaction.getTransactionDate());
			lastTrasactionResponseDto.setTransactionType(transaction.getTransactionType());
			
			lastTrasactionResponseDtoList.add(lastTrasactionResponseDto);
		}
		return lastTrasactionResponseDtoList;

	}

}
