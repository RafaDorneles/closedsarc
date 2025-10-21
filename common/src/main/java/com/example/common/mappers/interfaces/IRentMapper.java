package com.example.common.mappers.interfaces;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.requestsDTO.RentRequestDTO;
import com.example.common.models.Rent;

public interface IRentMapper {
    public RentDTO entityToDto(Rent rent);
    public Rent dtoToEntity(RentDTO rentDTO);
    public Rent requestToEntity(RentRequestDTO rentRequestDTO);
}
