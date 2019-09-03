package com.hcl.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.LastTrasactionResponseDto;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.repository.TransactionRepository;


@RunWith(MockitoJUnitRunner.class)
public class LastTopTransctionsImplTest {
	
	
	@InjectMocks LastTopTransctionsImpl lastTopTransctionsImpl;
	
	@Mock	TransactionRepository transactionRepository;
	Transaction transaction;
	List<Transaction> transactionList;
	
	@Before
	public void before()
	{
		transaction=new Transaction();
		transaction.setAccountNumber("1");
		transaction.setAmount(1000d);
		transaction.setDescription("discription");
		transaction.setTransactionId(1);
		transaction.setTransactionType("debit");
		
		transactionList=new ArrayList<>(); 
		transactionList.add(transaction);
		
	}
	
	@Test
	public void lastTransactions() {
		Mockito.when(transactionRepository.findByAccountNumber(transaction.getAccountNumber())).thenReturn(transactionList);
	

	List<LastTrasactionResponseDto> actula = lastTopTransctionsImpl.lastTransactions(transaction.getAccountNumber());
	
	
	Assert.assertEquals(1, actula.size());
	}

}
