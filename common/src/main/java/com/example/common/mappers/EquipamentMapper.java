package com.example.common.mappers;

import java.util.ArrayList;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.requestsDTO.EquipamentRequestDTO;
import com.example.common.models.Equipament;

public class EquipamentMapper {

    public static EquipamentDTO entityToDto(Equipament equipament) {
        if (equipament == null) {
            return null;
        }

        EquipamentDTO dto = new EquipamentDTO();
        dto.setId(equipament.getId());
        dto.setName(equipament.getName());
        dto.setRents(equipament.getRents());

        return dto;
    }

    public static Equipament dtoToEntity(EquipamentDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipament equipament = new Equipament();
        equipament.setId(dto.getId());
        equipament.setName(dto.getName());
        equipament.setRents(dto.getRents());

        return equipament;
    }

    public static Equipament requestToEntity(EquipamentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipament equipament = new Equipament();
        equipament.setName(dto.getName());
        equipament.setRents(new ArrayList<>());

        return equipament;
    }
}
