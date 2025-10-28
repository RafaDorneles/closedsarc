package com.example.datagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = {
    "com.example.datagateway",
    "com.example.common"
})
@EntityScan(basePackages = {
    "com.example.common.models"
})
@RequestMapping("/data")
public class DatagatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatagatewayApplication.class, args);
    }
}

