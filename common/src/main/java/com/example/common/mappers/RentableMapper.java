package com.example.common.mappers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.dtos.RentableDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.mappers.interfaces.IRentableMapper;
import com.example.common.models.Rentable;

public class RentableMapper implements IRentableMapper {

    @Autowired
    private IRentMapper rentMapper;

    @Override
    public RentableDTO entityToDto(Rentable rentable) {
        if (rentable == null) {
            return null;
        }
        RentableDTO dto = new RentableDTO();
        dto.setId(rentable.getId());
        dto.setRents(rentable.getRents().stream().map(rentMapper::entityToDto).collect(Collectors.toList()));
        return dto;

    }

    @Override
    public Rentable dtoToEntity(RentableDTO dto, Rentable rentable) {
        if (dto == null) {
            return null;
        }
        
        rentable.setId(dto.getId());
        rentable.setRents(dto.getRents().stream().map(rentMapper::dtoToEntity).collect(Collectors.toList()));
        return rentable;
    }
    
}
