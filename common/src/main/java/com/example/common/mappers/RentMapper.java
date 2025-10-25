package com.example.common.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.simpleDTOs.SimpleClassroomDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentableDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Classroom;
import com.example.common.models.Day;
import com.example.common.models.Period;
import com.example.common.models.Rent;
import com.example.common.models.Rentable;

@Component
public class RentMapper implements IRentMapper{

    @Override
    public RentDTO entityToDto(Rent rent) {
        if (rent == null) {
            return null;
        }
        
        SimpleClassroomDTO classroom = new SimpleClassroomDTO();
        classroom.setId(rent.getClassroom().getId());
        classroom.setNumberOfStudents(rent.getClassroom().getNumberOfStudents());
        classroom.setSubject(rent.getClassroom().getSubject());
        classroom.setPeriods(rent.getClassroom().getPeriods().stream()
                                .map(Period::name)
                                .toList());
        classroom.setDays(rent.getClassroom().getDays().stream()
                            .map(Day::name)
                            .toList());
        
        SimpleRentableDTO rentableItem = new SimpleRentableDTO();
        rentableItem.setId(rent.getRentableItem().getId());

        RentDTO dto = new RentDTO();
        dto.setId(rent.getId());            
        dto.setClassroom(classroom);
        dto.setRentableItem(rentableItem);
        dto.setRentDate(rent.getRentDate());
        
        return dto;
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

    @Override
    public SimpleRentDTO entityToSimpleDto(Rent rent) {
        if(rent == null) {
            return null;
        }

        SimpleRentDTO dto = new SimpleRentDTO();
        dto.setId(rent.getId());
        dto.setClassroomId(rent.getClassroom().getId());
        dto.setRentableItemId(rent.getRentableItem().getId());
        dto.setRentDate(rent.getRentDate());

        return dto;
    }
}
