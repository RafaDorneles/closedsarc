package com.example.professor_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.professor_service.services.ProfessorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{id}")
    public Mono<ProfessorDTO> getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @GetMapping("/{id}/classes")
    public Flux<SimpleCourseDTO> getCoursesByProfessorId(@PathVariable Long id) {
        return professorService.getCoursesByProfessorId(id);
    }
}
