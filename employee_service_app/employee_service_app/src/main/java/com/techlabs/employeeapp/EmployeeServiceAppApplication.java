package com.techlabs.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceAppApplication.class, args);
	}

}
