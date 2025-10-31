package com.example.professor_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.EquipementDTO;
import com.example.professor_service.services.EquipementService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
    
    @Autowired
    private EquipementService equipementService;

    @GetMapping("/")
    public Flux<EquipementDTO> getAllEquipements() {
        return equipementService.getAllEquipements();
    }

    @GetMapping("/{id}")
    public Mono<EquipementDTO> getEquipementById(@PathVariable Long id) {
        return equipementService.getEquipementById(id);
    }
}
