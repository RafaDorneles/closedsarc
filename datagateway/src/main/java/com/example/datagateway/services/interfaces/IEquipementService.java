package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;

public interface IEquipementService {
    List<EquipementDTO> getAllEquipements();
    EquipementDTO getEquipementById(Long id);
    EquipementDTO createEquipement(CreateEquipementDTO equipement);
    EquipementDTO updateEquipement(CreateEquipementDTO equipement, Long id);
    EquipementDTO deleteEquipement(Long id);
}
