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

import com.example.admin_service.services.EquipementService;
import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;

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
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EquipementDTO> createEquipement(@RequestBody CreateEquipementDTO dto) {
        return equipementService.createEquipement(dto);
    }
    
    @PutMapping("/{id}")
    public Mono<EquipementDTO> updateEquipement(@PathVariable Long id, @RequestBody CreateEquipementDTO dto) {
        return equipementService.updateEquipement(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<EquipementDTO> deleteEquipement(@PathVariable Long id) {
        return equipementService.deleteEquipement(id);
    }
}
