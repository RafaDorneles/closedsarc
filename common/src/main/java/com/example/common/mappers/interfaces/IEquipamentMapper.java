package com.example.common.mappers.interfaces;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.requestsDTO.EquipamentRequestDTO;
import com.example.common.models.Equipament;

public interface IEquipamentMapper {
    EquipamentDTO entityToDto(Equipament equipament);
    Equipament dtoToEntity(EquipamentDTO equipamentDTO);
    Equipament requestToEntity(EquipamentRequestDTO equipamentRequestDTO);
}
