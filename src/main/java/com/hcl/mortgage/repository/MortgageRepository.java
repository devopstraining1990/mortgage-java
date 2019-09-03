package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.mortgage.entity.Mortgage;

public interface MortgageRepository extends JpaRepository<Mortgage, Integer> {

}
