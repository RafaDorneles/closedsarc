package com.example.common.mappers.interfaces;

import com.example.common.dtos.RentableDTO;
import com.example.common.models.Rentable;

public interface IRentableMapper {
    public RentableDTO entityToDto(Rentable rentable);
}
