package com.example.common.mappers.interfaces;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.createDTOs.CreateRentDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentDTO;
import com.example.common.models.Course;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;

public interface IRentMapper {
    public RentDTO entityToDto(Rent rent);
    public Rent requestToEntity(Course course, Rentable rentableItem, CreateRentDTO dto);
    public SimpleRentDTO dtoToSimpleDto(RentDTO dto);
    public SimpleRentDTO entityToSimpleDto(Rent rent);
}
