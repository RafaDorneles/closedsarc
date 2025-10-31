package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProfessorWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<ProfessorDTO> getAllProfessors() {
        return webClient.get()
                .uri("/professors/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(ProfessorDTO.class);
    }

    public Mono<ProfessorDTO> getProfessorById(Long id) {
        return webClient.get()
                .uri("/professors/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(ProfessorDTO.class);
    }

    public Mono<ProfessorDTO> createProfessor(CreateProfessorDTO dto) {
        return webClient.post()
                .uri("/professors/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ProfessorDTO.class);
    }

    public Mono<ProfessorDTO> updateProfessor(Long id, CreateProfessorDTO dto) {
        return webClient.put()
                .uri("/professors/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ProfessorDTO.class);
    }

    public Mono<ProfessorDTO> deleteProfessor(Long id) {
        return webClient.delete()
                .uri("/professors/{id}", id)
                .retrieve()
                .bodyToMono(ProfessorDTO.class);
    }
}
