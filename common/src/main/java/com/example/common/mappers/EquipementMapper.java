package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;
import com.example.common.mappers.interfaces.IEquipementMapper;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Equipement;

@Component
public class EquipementMapper implements IEquipementMapper {

    @Autowired
    private IRentMapper rentMapper;
    
    @Override
    public EquipementDTO entityToDto(Equipement equipement) {
        if (equipement == null) {
            return null;
        }

        EquipementDTO dto = new EquipementDTO();
        dto.setId(equipement.getId());
        dto.setName(equipement.getName());
        dto.setRents(equipement.getRents().stream()
                .map(rentMapper::entityToSimpleDto)
                .toList());

        return dto;
    }

    @Override
    public Equipement requestToEntity(CreateEquipementDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipement equipement = new Equipement();
        equipement.setName(dto.getName());
        equipement.setRents(new ArrayList<>());

        return equipement;
    }
}
