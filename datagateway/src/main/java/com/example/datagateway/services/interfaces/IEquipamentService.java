package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.requestsDTO.EquipamentRequestDTO;

public interface IEquipamentService {
    List<EquipamentDTO> getAllEquipaments();
    EquipamentDTO getEquipamentById(Long id);
    EquipamentDTO createEquipament(EquipamentRequestDTO equipament);
    EquipamentDTO updateEquipament(EquipamentRequestDTO equipament, Long id);
    EquipamentDTO deleteEquipament(Long id);
}
