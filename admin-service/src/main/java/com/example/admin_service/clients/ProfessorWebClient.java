package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;
import com.example.common.exceptions.ApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProfessorWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<ProfessorDTO> getAllProfessors() {
        return webClient.get()
                .uri("/professors")
                .retrieve()
                .bodyToFlux(ProfessorDTO.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode() == HttpStatus.NOT_FOUND)
                        return Flux.empty();
                    return Flux.error(ex);
                });
    }

    public Mono<ProfessorDTO> getProfessorById(Long id) {
        return webClient.get()
                .uri("/professors/{id}", id)
                .retrieve()
                .bodyToMono(ProfessorDTO.class)
                .onErrorResume(WebClientResponseException.class, ex ->
                        Mono.error(new ApiException("Error while getting professor", HttpStatus.NOT_FOUND))
                );
    }

    public Mono<ProfessorDTO> createProfessor(CreateProfessorDTO dto) {
        return webClient.post()
                .uri("/professors")
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
