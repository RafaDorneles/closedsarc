package com.example.professor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/professor")
public class ProfessorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorServiceApplication.class, args);
	}

}
