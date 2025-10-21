package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.requestsDTO.EquipamentRequestDTO;
import com.example.common.mappers.interfaces.IEquipamentMapper;
import com.example.common.models.Equipament;

@Component
public class EquipamentMapper implements IEquipamentMapper {

    @Override
    public EquipamentDTO entityToDto(Equipament equipament) {
        if (equipament == null) {
            return null;
        }

        EquipamentDTO dto = new EquipamentDTO();
        dto.setId(equipament.getId());
        dto.setName(equipament.getName());
        dto.setRents(equipament.getRents());

        return dto;
    }

    @Override
    public Equipament dtoToEntity(EquipamentDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipament equipament = new Equipament();
        equipament.setId(dto.getId());
        equipament.setName(dto.getName());
        equipament.setRents(dto.getRents());

        return equipament;
    }

    @Override
    public Equipament requestToEntity(EquipamentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipament equipament = new Equipament();
        equipament.setName(dto.getName());
        equipament.setRents(new ArrayList<>());

        return equipament;
    }
}
