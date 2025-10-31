package com.example.professor_service.controllers;

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

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.professor_service.services.RentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
    
@RestController
@RequestMapping("/rents")
public class RentController {
    
    @Autowired
    private RentService rentService;

    @GetMapping("/")
    public Flux<RentDTO> getAllRents() {
        return rentService.getAllRents();
    }

    @GetMapping("/{id}")
    public Mono<RentDTO> getRentById(@PathVariable Long id) {
        return rentService.getRentById(id);
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RentDTO> createRent(@RequestBody CreateRentDTO dto) {
        return rentService.createRent(dto);
    }
    
    @PutMapping("/{id}")
    public Mono<RentDTO> updateRent(@PathVariable Long id, @RequestBody CreateRentDTO dto) {
        return rentService.updateRent(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<RentDTO> deleteRent(@PathVariable Long id) {
        return rentService.deleteRent(id);
    }
}
