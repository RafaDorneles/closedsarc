package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.AdminDTO;
import com.example.common.dtos.createDTOs.CreateAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AdminWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<AdminDTO> getAllAdmins() {
        return webClient.get()
                .uri("/admins/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(AdminDTO.class);
    }

    public Mono<AdminDTO> getAdminById(Long id) {
        return webClient.get()
                .uri("/admins/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(AdminDTO.class);
    }

    public Mono<AdminDTO> createAdmin(CreateAdminDTO dto) {
        return webClient.post()
                .uri("/admins/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(AdminDTO.class);
    }

    public Mono<AdminDTO> updateAdmin(Long id, CreateAdminDTO dto) {
        return webClient.put()
                .uri("/admins/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(AdminDTO.class);
    }

    public Mono<AdminDTO> deleteAdmin(Long id) {
        return webClient.delete()
                .uri("/admins/{id}", id)
                .retrieve()
                .bodyToMono(AdminDTO.class);
    }
}