package com.example.common.mappers.interfaces;

import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;
import com.example.common.models.Equipement;

public interface IEquipementMapper {
    EquipementDTO entityToDto(Equipement equipement);
    Equipement requestToEntity(CreateEquipementDTO createEquipementDTO);
}
