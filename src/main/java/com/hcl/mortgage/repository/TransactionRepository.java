package com.hcl.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.mortgage.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByAccountNumber(String accountNumber);

}
