package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.EquipementWebClient;
import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EquipementService {
    
    @Autowired
    EquipementWebClient equipementWebClient;

    public Flux<EquipementDTO> getAllEquipements() {
        return equipementWebClient.getAllEquipements();
    }

    public Mono<EquipementDTO> getEquipementById(Long id) {
        return equipementWebClient.getEquipementById(id);
    }

    public Mono<EquipementDTO> createEquipement(CreateEquipementDTO dto) {
        return equipementWebClient.createEquipement(dto);
    }

    public Mono<EquipementDTO> updateEquipement(Long id, CreateEquipementDTO dto){
        return equipementWebClient.updateEquipement(id, dto);
    }

    public Mono<EquipementDTO> deleteEquipement(Long id) {
        return equipementWebClient.deleteEquipement(id);
    }
}
