package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;
import com.example.common.mappers.interfaces.IEquipamentMapper;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Equipament;

@Component
public class EquipamentMapper implements IEquipamentMapper {

    @Autowired
    private IRentMapper rentMapper;
    
    @Override
    public EquipamentDTO entityToDto(Equipament equipament) {
        if (equipament == null) {
            return null;
        }

        EquipamentDTO dto = new EquipamentDTO();
        dto.setId(equipament.getId());
        dto.setName(equipament.getName());
        dto.setRents(equipament.getRents().stream()
                .map(rentMapper::entityToSimpleDto)
                .toList());

        return dto;
    }

    @Override
    public Equipament requestToEntity(CreateEquipamentDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipament equipament = new Equipament();
        equipament.setName(dto.getName());
        equipament.setRents(new ArrayList<>());

        return equipament;
    }
}
