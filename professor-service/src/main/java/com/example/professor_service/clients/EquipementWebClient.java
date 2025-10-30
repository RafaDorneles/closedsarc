package com.example.professor_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.common.dtos.EquipementDTO;
import com.example.professor_service.exceptions.RemoteApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EquipementWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<EquipementDTO> getAllEquipements(){
        return webClient.get()
            .uri("/equipements/")
            .retrieve()
            .onStatus(status -> status.isError(), response -> 
                response.bodyToMono(String.class)
                        .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
            )
            .bodyToFlux(EquipementDTO.class);
    }

    public Mono<EquipementDTO> getEquipementById(Long id){
        return webClient.get()
            .uri("/equipements/{id}", id)
            .retrieve()
            .onStatus(status -> status.isError(), response -> 
                response.bodyToMono(String.class)
                        .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
            )
            .bodyToMono(EquipementDTO.class);
    }
}
