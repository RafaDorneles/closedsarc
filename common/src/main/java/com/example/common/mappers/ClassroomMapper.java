package com.example.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.common.dtos.ClassroomDTO;
import com.example.common.dtos.createDTOs.CreateClassroomDTO;
import com.example.common.dtos.simpleDTOs.SimpleClassroomDTO;
import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.IClassroomMapper;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Classroom;
import com.example.common.models.Day;
import com.example.common.models.Period;

@Component
public class ClassroomMapper implements IClassroomMapper {

    @Autowired
    private IRentMapper rentMapper;
    
    @Override
    public ClassroomDTO entityToDto(Classroom classroom) {
        if (classroom == null) {
            return null;
        }

        ClassroomDTO dto = new ClassroomDTO();
        dto.setId(classroom.getId());
        dto.setNumberOfStudents(classroom.getNumberOfStudents());
        dto.setSubject(classroom.getSubject());
        dto.setPeriods(classroom.getPeriods().stream()
                    .map(Period::name)
                    .toList());
        dto.setDays(classroom.getDays().stream()
                    .map(Day::name)
                    .toList());

        SimpleProfessorDTO simpleProfessor = new SimpleProfessorDTO();
        simpleProfessor.setId(classroom.getProfessor().getId());
        simpleProfessor.setName(classroom.getProfessor().getName());
        dto.setProfessor(simpleProfessor);
        dto.setRents(classroom.getRents().stream()
                    .map(rentMapper::entityToSimpleDto)
                    .toList());

        return dto;
    }

    @Override
    public Classroom requestToEntity(CreateClassroomDTO roomRequestDTO) {
        if (roomRequestDTO == null) {
            return null;
        }

        Classroom classroom = new Classroom();
        classroom.setNumberOfStudents(roomRequestDTO.getNumberOfStudents());
        classroom.setSubject(roomRequestDTO.getSubject());
        classroom.setPeriods(roomRequestDTO.getPeriods().stream()
                    .map(periodStr -> stringToPeriod(periodStr))
                    .toList());
        classroom.setDays(roomRequestDTO.getDays().stream()
                    .map(dayStr -> stringToDay(dayStr))
                    .toList());

        return classroom;
    }

    @Override
    public SimpleClassroomDTO entityToSimpleDto(Classroom classroom) {
        if (classroom == null) {
            return null;
        }
        SimpleClassroomDTO dto = new SimpleClassroomDTO();
        dto.setId(classroom.getId());
        dto.setSubject(classroom.getSubject());
        dto.setPeriods(classroom.getPeriods().stream()
                        .map(Period::name)
                        .toList());
        return dto;
    }

    private Day stringToDay(String dayStr) {
        try {
            return Day.valueOf(dayStr);
        } catch (IllegalArgumentException e) {
            throw new ApiException("Invalid day value: " + dayStr, HttpStatus.BAD_REQUEST);
        }
    }

    private Period stringToPeriod(String periodStr) {
        try {
            return Period.valueOf(periodStr);
        } catch (IllegalArgumentException e) {
            throw new ApiException("Invalid period value: " + periodStr, HttpStatus.BAD_REQUEST);
        }
    }
}
