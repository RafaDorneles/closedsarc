package com.example.professor_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.professor_service.exceptions.RemoteApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProfessorWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<SimpleCourseDTO> getCoursesByProfessorId(@PathVariable Long id) {
    return webClient.get()
        .uri("/professors/{id}", id)
        .retrieve()
        .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
        .bodyToMono(ProfessorDTO.class)
        .flatMapMany(prof -> Flux.fromIterable(prof.getClasses()));
    }

    public Mono<ProfessorDTO> getProfessorById(@PathVariable Long id) {
    return webClient.get()
        .uri("/professors/{id}", id)
        .retrieve()
        .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
        .bodyToMono(ProfessorDTO.class);
    }
}
