package com.example.common.mappers.interfaces;

import com.example.common.dtos.RentableDTO;
import com.example.common.models.Rentable;

public interface IRentableMapper {
    RentableDTO entityToDto(Rentable rentable);
    Rentable dtoToEntity(RentableDTO dto);
}
