package com.example.datagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
    "com.example.datagateway",
    "com.example.common"
})
@EntityScan(basePackages = {
    "com.example.common.models"
})
public class DatagatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatagatewayApplication.class, args);
	}

}
