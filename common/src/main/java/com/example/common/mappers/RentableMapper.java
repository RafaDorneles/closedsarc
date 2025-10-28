package com.example.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.RentableDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.mappers.interfaces.IRentableMapper;
import com.example.common.models.Rentable;

@Component
public class RentableMapper implements IRentableMapper{

    @Autowired
    private IRentMapper rentMapper;

    @Override
    public RentableDTO entityToDto(Rentable rentable) {
        if (rentable == null) {
            return null;
        }

        RentableDTO dto = new RentableDTO();
        dto.setId(rentable.getId());

        if (rentable.getRents() != null) {
            dto.setRents(
                rentable.getRents()
                        .stream()
                        .map(rentMapper::entityToSimpleDto)
                        .toList()
            );
        }

        return dto;
    }
}