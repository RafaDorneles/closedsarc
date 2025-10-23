package com.example.common.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.common.dtos.RentDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Classroom;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;

@Component
public class RentMapper implements IRentMapper{

    @Override
    public RentDTO entityToDto(Rent rent) {
        if (rent == null) {
            return null;
        }

        RentDTO dto = new RentDTO();
        dto.setId(rent.getId());
        dto.setClassroom(rent.getClassroom());
        dto.setRentableItem(rent.getRentableItem());
        dto.setRentDate(rent.getRentDate());
        
        return dto;
    }

    @Override
    public Rent dtoToEntity(RentDTO dto) {
        if (dto == null) {
            return null;
        }

        Rent rent = new Rent();
        rent.setId(dto.getId());
        rent.setClassroom(dto.getClassroom());
        rent.setRentableItem(dto.getRentableItem());
        rent.setRentDate(dto.getRentDate());

        return rent;
    }

    @Override
    public Rent requestToEntity(Classroom classroom, Rentable rentableItem) {
        if (classroom == null || rentableItem == null) {
            return null;
        }

        Rent rent = new Rent();
        rent.setClassroom(classroom);
        rent.setRentableItem(rentableItem);
        rent.setRentDate(LocalDateTime.now());
        return rent;

    }
}
