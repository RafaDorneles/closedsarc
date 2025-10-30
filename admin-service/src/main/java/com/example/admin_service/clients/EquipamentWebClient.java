package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EquipamentWebClient {

    @Autowired
    private WebClient webClient;

    public Flux<EquipamentDTO> getAllEquipaments() {
        return webClient.get()
                .uri("/equipaments/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(EquipamentDTO.class);
    }

    public Mono<EquipamentDTO> getEquipamentById(Long id) {
        return webClient.get()
                .uri("/equipaments/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(EquipamentDTO.class);
    }

    public Mono<EquipamentDTO> createEquipament(CreateEquipamentDTO dto) {
        return webClient.post()
                .uri("/equipaments/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(EquipamentDTO.class);
    }

    public Mono<EquipamentDTO> deleteEquipament(Long id) {
        return webClient.delete()
                .uri("/equipaments/{id}", id)
                .retrieve()
                .bodyToMono(EquipamentDTO.class);
    }
}
