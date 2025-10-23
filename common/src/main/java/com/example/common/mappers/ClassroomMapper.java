package com.example.common.mappers;

import org.springframework.http.HttpStatus;

import com.example.common.dtos.ClassroomDTO;
import com.example.common.dtos.requestsDTO.ClassroomRequestDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.IClassroomMapper;
import com.example.common.models.Classroom;
import com.example.common.models.Day;
import com.example.common.models.Period;

public class ClassroomMapper implements IClassroomMapper {

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
        dto.setProfessor(classroom.getProfessor());
        dto.setRents(classroom.getRents());

        
        return dto;
    }

    @Override
    public Classroom dtoToEntity(ClassroomDTO classroomDTO) {
        if (classroomDTO == null) {
            return null;
        }

        Classroom classroom = new Classroom();
        classroom.setId(classroomDTO.getId());
        classroom.setNumberOfStudents(classroomDTO.getNumberOfStudents());
        classroom.setSubject(classroomDTO.getSubject());
        classroom.setProfessor(classroomDTO.getProfessor());
        classroom.setRents(classroomDTO.getRents());
        classroom.setPeriods(classroomDTO.getPeriods().stream()
                    .map(periodStr -> {
                        try {
                            return Period.valueOf(periodStr);
                        } catch (IllegalArgumentException e) {
                            throw new ApiException("Invalid period value: " + periodStr, HttpStatus.BAD_REQUEST);
                        }
                    })
                    .toList());
        classroom.setDays(classroomDTO.getDays().stream()
                    .map(dayStr -> {
                        try {
                            return Day.valueOf(dayStr);
                        } catch (IllegalArgumentException e) {
                            throw new ApiException("Invalid day value: " + dayStr, HttpStatus.BAD_REQUEST);
                        }
                    })
                    .toList());

        return classroom;
    }

    @Override
    public Classroom requestToEntity(ClassroomRequestDTO roomRequestDTO) {
        if (roomRequestDTO == null) {
            return null;
        }

        Classroom classroom = new Classroom();
        classroom.setNumberOfStudents(roomRequestDTO.getNumberOfStudents());
        classroom.setSubject(roomRequestDTO.getSubject());
        classroom.setPeriods(roomRequestDTO.getPeriods().stream()
                    .map(periodStr -> {
                        try {
                            return Period.valueOf(periodStr);
                        } catch (IllegalArgumentException e) {
                            throw new ApiException("Invalid period value: " + periodStr, HttpStatus.BAD_REQUEST);
                        }
                    })
                    .toList());
        classroom.setDays(roomRequestDTO.getDays().stream()
                    .map(dayStr -> {
                        try {
                            return Day.valueOf(dayStr);
                        } catch (IllegalArgumentException e) {
                            throw new ApiException("Invalid day value: " + dayStr, HttpStatus.BAD_REQUEST);
                        }
                    })
                    .toList());

        return classroom;
    }
    
}
