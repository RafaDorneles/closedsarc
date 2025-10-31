package com.example.admin_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin_service.services.ProfessorService;
import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/")
    public Flux<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Mono<ProfessorDTO> getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProfessorDTO> createProfessor(@RequestBody CreateProfessorDTO dto) {
        return professorService.createProfessor(dto);
    }
    
    @PutMapping("/{id}")
    public Mono<ProfessorDTO> updateProfessor(@PathVariable Long id, @RequestBody CreateProfessorDTO dto) {
        return professorService.updateProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<ProfessorDTO> deleteProfessor(@PathVariable Long id) {
        return professorService.deleteProfessor(id);
    }
}
