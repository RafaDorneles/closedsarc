package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.admin_service.exceptions.RemoteApiException;
import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CourseWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<CourseDTO> getAllCourses() {
        return webClient.get()
                .uri("/courses/")
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToFlux(CourseDTO.class);
    }

    public Mono<CourseDTO> getCourseById(Long id) {
        return webClient.get()
                .uri("/courses/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> 
                    response.bodyToMono(String.class)
                            .flatMap(body -> Mono.error(new RemoteApiException(body, HttpStatus.valueOf(response.statusCode().value()))))
                )
                .bodyToMono(CourseDTO.class);
    }

    public Mono<CourseDTO> createCourse(CreateCourseDTO dto) {
        return webClient.post()
                .uri("/courses/")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(CourseDTO.class);
    }

    public Mono<CourseDTO> updateCourse(Long id, CreateCourseDTO dto) {
        return webClient.put()
                .uri("/courses/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(CourseDTO.class);
    }

    public Mono<CourseDTO> deleteCourse(Long id) {
        return webClient.delete()
                .uri("/courses/{id}", id)
                .retrieve()
                .bodyToMono(CourseDTO.class);
    }

    public Mono<CourseDTO> assignProfessorToCourse(Long professorId, Long courseId){
        return webClient.put()
                .uri("/courses/{courseId}/professor/{professorId}")
                .retrieve()
                .bodyToMono(CourseDTO.class);
    }
}
