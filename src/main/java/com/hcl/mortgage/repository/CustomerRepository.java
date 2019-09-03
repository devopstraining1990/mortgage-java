package com.hcl.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.mortgage.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer>  findByLoginIdAndPassword(String loginId,String password);

}
