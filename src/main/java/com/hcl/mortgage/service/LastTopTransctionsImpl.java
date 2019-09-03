package com.hcl.mortgage.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

		
		 List<Transaction> sortedList = transactions.stream()
					.sorted(Comparator.comparingInt(Transaction::getTransactionId))
					.collect(Collectors.toList());
			Collections.reverse(sortedList);
		
		List<LastTrasactionResponseDto> lastTrasactionResponseDtoList=new ArrayList<>();
		
		
		for (Transaction transaction : sortedList) {
			
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
