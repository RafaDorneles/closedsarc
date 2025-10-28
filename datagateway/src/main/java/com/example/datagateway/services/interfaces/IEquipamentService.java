package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;

public interface IEquipamentService {
    List<EquipamentDTO> getAllEquipaments();
    EquipamentDTO getEquipamentById(Long id);
    EquipamentDTO createEquipament(CreateEquipamentDTO equipament);
    EquipamentDTO updateEquipament(CreateEquipamentDTO equipament, Long id);
    EquipamentDTO deleteEquipament(Long id);
}
