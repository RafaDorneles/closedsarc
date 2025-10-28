package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class CourseWebClient {
    
    @Autowired
    private WebClient webClient;
}
