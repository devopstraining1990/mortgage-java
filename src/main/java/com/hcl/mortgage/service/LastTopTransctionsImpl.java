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


/**
 * @author sairam
 * 
 * **/

@Service
public class LastTopTransctionsImpl implements LastTopTransctions {

	@Autowired
	TransactionRepository transactionRepository;

	/**
	 * @author sairam
	 * get the list of transactions of account
	 * @param accountNumber is the running work
	 * 
	 * **/
	@Override
	public List<LastTrasactionResponseDto> lastTransactions(String accountNumber) {

		List<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber);

		
		 List<Transaction> sortedList = transactions.stream()
					.sorted(Comparator.comparingInt(Transaction::getTransactionId))
					.collect(Collectors.toList());
			Collections.reverse(sortedList);
		
		List<LastTrasactionResponseDto> lastTrasactionResponseDtoList=new ArrayList<>();
		
		
		int tarnsactionsCount=0;
		
		for (Transaction transaction : sortedList) {
			if(tarnsactionsCount<5) {
			LastTrasactionResponseDto lastTrasactionResponseDto = new LastTrasactionResponseDto();
			
			lastTrasactionResponseDto.setAccountNumber(transaction.getAccountNumber());
			lastTrasactionResponseDto.setAmount(transaction.getAmount());
			lastTrasactionResponseDto.setDecription(transaction.getDescription());
			lastTrasactionResponseDto.setTransactionDate(transaction.getTransactionDate());
			lastTrasactionResponseDto.setTransactionType(transaction.getTransactionType());
			
			lastTrasactionResponseDtoList.add(lastTrasactionResponseDto);
			}
			
			tarnsactionsCount++;
		}
		return lastTrasactionResponseDtoList; 

	}

}
