package com.prizy.pricer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.prizy.pricer.*")
@ComponentScan(basePackages = "com.prizy.pricer.*")
public class PricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricerApplication.class, args);
	}
}
