package com.example.professor_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.dtos.EquipementDTO;
import com.example.professor_service.clients.EquipementWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EquipementService {
    
    @Autowired
    private EquipementWebClient equipementWebClient;

    public Flux<EquipementDTO> getAllEquipements(){
        return equipementWebClient.getAllEquipements();
    }

    public Mono<EquipementDTO> getEquipementById(Long id){
        return equipementWebClient.getEquipementById(id);
    }
}
