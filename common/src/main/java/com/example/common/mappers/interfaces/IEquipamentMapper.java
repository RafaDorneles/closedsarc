package com.example.common.mappers.interfaces;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;
import com.example.common.models.Equipament;

public interface IEquipamentMapper {
    EquipamentDTO entityToDto(Equipament equipament);
    Equipament requestToEntity(CreateEquipamentDTO createEquipamentDTO);
}
