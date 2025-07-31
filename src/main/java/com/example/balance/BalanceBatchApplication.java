package com.example.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "com.example.balance", "com.example.financial" })
public class BalanceBatchApplication {

	public static void main(String[] args) {
	    SpringApplication.run(BalanceBatchApplication.class, args);
	}

}
