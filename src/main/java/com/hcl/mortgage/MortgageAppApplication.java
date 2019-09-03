package com.hcl.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MortgageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageAppApplication.class, args);
	}

}
