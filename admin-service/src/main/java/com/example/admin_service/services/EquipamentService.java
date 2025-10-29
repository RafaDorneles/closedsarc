package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.EquipamentWebClient;
import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EquipamentService {
    
    @Autowired
    EquipamentWebClient equipamentWebClient;

    public Flux<EquipamentDTO> getAllEquipaments() {
        return equipamentWebClient.getAllEquipaments();
    }

    public Mono<EquipamentDTO> getEquipamentById(Long id) {
        return equipamentWebClient.getEquipamentById(id);
    }

    public Mono<EquipamentDTO> createEquipament(CreateEquipamentDTO dto) {
        return equipamentWebClient.createEquipament(dto);
    }

    public Mono<EquipamentDTO> deleteEquipament(Long id) {
        return equipamentWebClient.deleteEquipament(id);
    }
}
