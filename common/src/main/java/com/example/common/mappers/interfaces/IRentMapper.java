package com.example.common.mappers.interfaces;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentDTO;
import com.example.common.models.Classroom;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;

public interface IRentMapper {
    public RentDTO entityToDto(Rent rent);
    public Rent requestToEntity(Classroom classroom, Rentable rentableItem);
    public SimpleRentDTO entityToSimpleDto(Rent rent);
}
