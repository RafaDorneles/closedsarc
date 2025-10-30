package com.example.professor_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.professor_service.exceptions.RemoteApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RentWebClient {
    
    @Autowired
    private WebClient webClient;
    
    public Flux<RentDTO> getAllRents() {
        return webClient.get()
                .uri("/rents/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(RentDTO.class);
    }

    public Mono<RentDTO> getRentById(Long id) {
        return webClient.get()
                .uri("/rents/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(RentDTO.class);
    }

    public Mono<RentDTO> createRent(CreateRentDTO dto) {
        return webClient.post()
                .uri("/rents/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(RentDTO.class);
    }

    public Mono<RentDTO> updateRent(Long id, CreateRentDTO dto) {
        return webClient.put()
                .uri("/rents/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(RentDTO.class);
    }

    public Mono<RentDTO> deleteRent(Long id) {
        return webClient.delete()
                .uri("/rents/{id}", id)
                .retrieve()
                .bodyToMono(RentDTO.class);
    }
}
