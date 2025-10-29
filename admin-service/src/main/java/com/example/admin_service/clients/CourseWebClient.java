package com.example.admin_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.common.exceptions.ApiException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CourseWebClient {
    
    @Autowired
    private WebClient webClient;

    public Flux<CourseDTO> getAllCourses() {
        return webClient.get()
                .uri("/courses")
                .retrieve()
                .bodyToFlux(CourseDTO.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode() == HttpStatus.NOT_FOUND)
                        return Flux.empty();
                    return Flux.error(ex);
                });
    }

    public Mono<CourseDTO> getCourseById(Long id) {
        return webClient.get()
                .uri("/courses/{id}", id)
                .retrieve()
                .bodyToMono(CourseDTO.class)
                .onErrorResume(WebClientResponseException.class, ex ->
                        Mono.error(new ApiException("Error while getting course", HttpStatus.NOT_FOUND))
                );
    }

    public Mono<CourseDTO> createCourse(CreateCourseDTO dto) {
        return webClient.post()
                .uri("/courses")
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
