package com.basanta.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.basanta.security.repository")
//@EntityScan("com.basanta.security.entity")
public class EazyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankApplication.class, args);
	}

}
