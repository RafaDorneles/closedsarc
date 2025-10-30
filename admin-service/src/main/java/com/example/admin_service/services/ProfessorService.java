package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.ProfessorWebClient;
import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessorService {

    @Autowired
    ProfessorWebClient professorWebClient;

    public Flux<ProfessorDTO> getAllProfessors() {
        return professorWebClient.getAllProfessors();
    }

    public Mono<ProfessorDTO> getProfessorById(Long id) {
        return professorWebClient.getProfessorById(id);
    }

    public Mono<ProfessorDTO> createProfessor(CreateProfessorDTO dto) {
        return professorWebClient.createProfessor(dto);
    }

    public Mono<ProfessorDTO> updateProfessor(Long id, CreateProfessorDTO dto){
        return professorWebClient.updateProfessor(id, dto);
    }

    public Mono<ProfessorDTO> deleteProfessor(Long id) {
        return professorWebClient.deleteProfessor(id);
    }
}
