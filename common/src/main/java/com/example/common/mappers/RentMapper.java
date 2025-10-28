package com.example.common.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.common.dtos.RentDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentDTO;
import com.example.common.dtos.simpleDTOs.SimpleRentableDTO;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Course;
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
        
        SimpleCourseDTO course = new SimpleCourseDTO();
        course.setId(rent.getCourse().getId());
        course.setNumberOfStudents(rent.getCourse().getNumberOfStudents());
        course.setSubject(rent.getCourse().getSubject());
        course.setPeriods(rent.getCourse().getPeriods().stream()
                                .map(Period::name)
                                .toList());
        course.setDays(rent.getCourse().getDays().stream()
                            .map(Day::name)
                            .toList());
        
        SimpleRentableDTO rentableItem = new SimpleRentableDTO();
        rentableItem.setId(rent.getRentableItem().getId());

        RentDTO dto = new RentDTO();
        dto.setId(rent.getId());            
        dto.setCourse(course);
        dto.setRentableItem(rentableItem);
        dto.setRentDate(rent.getRentDate());
        
        return dto;
    }

    @Override
    public Rent requestToEntity(Course course, Rentable rentableItem) {
        if (course == null || rentableItem == null) {
            return null;
        }

        Rent rent = new Rent();
        rent.setCourse(course);
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
        dto.setCourseId(rent.getCourse().getId());
        dto.setRentableItemId(rent.getRentableItem().getId());
        dto.setRentDate(rent.getRentDate());

        return dto;
    }

    @Override
    public SimpleRentDTO dtoToSimpleDto(RentDTO dto) {
        if(dto == null) {
            return null;
        }

        SimpleRentDTO simpleRent = new SimpleRentDTO();
        simpleRent.setId(dto.getId());
        simpleRent.setCourseId(dto.getCourse().getId());
        simpleRent.setRentableItemId(dto.getRentableItem().getId());
        simpleRent.setRentDate(dto.getRentDate());

        return simpleRent;
    }
}
