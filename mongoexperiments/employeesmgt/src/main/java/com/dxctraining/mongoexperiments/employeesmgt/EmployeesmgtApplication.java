package com.dxctraining.mongoexperiments.employeesmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeesmgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesmgtApplication.class, args);

	}

}
