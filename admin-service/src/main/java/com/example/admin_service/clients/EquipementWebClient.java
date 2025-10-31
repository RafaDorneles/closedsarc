package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EquipementWebClient {

    @Autowired
    private WebClient webClient;

    public Flux<EquipementDTO> getAllEquipements() {
        return webClient.get()
                .uri("/equipements/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(EquipementDTO.class);
    }

    public Mono<EquipementDTO> getEquipementById(Long id) {
        return webClient.get()
                .uri("/equipements/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(EquipementDTO.class);
    }

    public Mono<EquipementDTO> createEquipement(CreateEquipementDTO dto) {
        return webClient.post()
                .uri("/equipements/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(EquipementDTO.class);
    }

    public Mono<EquipementDTO> updateEquipement(Long id, CreateEquipementDTO dto) {
        return webClient.put()
                .uri("/equipements/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(EquipementDTO.class);
    }

    public Mono<EquipementDTO> deleteEquipement(Long id) {
        return webClient.delete()
                .uri("/equipements/{id}", id)
                .retrieve()
                .bodyToMono(EquipementDTO.class);
    }
}
