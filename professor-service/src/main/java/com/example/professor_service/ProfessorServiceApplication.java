package com.example.professor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProfessorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorServiceApplication.class, args);
	}

}
