package com.example.datagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.example.datagateway",
    "com.example.common"
})
@EntityScan(basePackages = {
    "com.example.common.models"
})
@EnableJpaRepositories(basePackages = {
    "com.example.datagateway.repositories"
})
public class DatagatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatagatewayApplication.class, args);
    }
}

