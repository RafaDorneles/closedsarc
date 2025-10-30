package com.example.professor_service.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.professor_service.clients.ProfessorWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProfessorService {
    
    @Autowired
    private ProfessorWebClient professorWebClient;

    public Flux<SimpleCourseDTO> getCoursesByProfessorId(Long id){
        return professorWebClient.getCoursesByProfessorId(id);
    }

    public Mono<ProfessorDTO> getProfessorById(Long id){
        return professorWebClient.getProfessorById(id);
    }
}
