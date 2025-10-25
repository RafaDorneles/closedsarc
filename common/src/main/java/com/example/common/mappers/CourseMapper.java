package com.example.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.ICourseMapper;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Course;
import com.example.common.models.Day;
import com.example.common.models.Period;

@Component
public class CourseMapper implements ICourseMapper {

    @Autowired
    private IRentMapper rentMapper;
    
    @Override
    public CourseDTO entityToDto(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO dto = new CourseDTO();
        
        SimpleProfessorDTO simpleProfessor = new SimpleProfessorDTO();
        simpleProfessor.setId(course.getProfessor().getId());
        simpleProfessor.setEmail(course.getProfessor().getEmail());
        simpleProfessor.setName(course.getProfessor().getName());
        
        dto.setId(course.getId());
        dto.setNumberOfStudents(course.getNumberOfStudents());
        dto.setSubject(course.getSubject());
        dto.setPeriods(course.getPeriods().stream()
                    .map(Period::name)
                    .toList());
        dto.setDays(course.getDays().stream()
                    .map(Day::name)
                    .toList());
        dto.setProfessor(simpleProfessor);
        dto.setRents(course.getRents().stream()
                    .map(rentMapper::entityToDto)
                    .toList());

        return dto;
    }

    @Override
    public Course requestToEntity(CreateCourseDTO roomRequestDTO) {
        if (roomRequestDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setNumberOfStudents(roomRequestDTO.getNumberOfStudents());
        course.setSubject(roomRequestDTO.getSubject());
        course.setPeriods(roomRequestDTO.getPeriods().stream()
                    .map(periodStr -> stringToPeriod(periodStr))
                    .toList());
        course.setDays(roomRequestDTO.getDays().stream()
                    .map(dayStr -> stringToDay(dayStr))
                    .toList());

        return course;
    }

    @Override
    public SimpleCourseDTO entityToSimpleDto(Course course) {
        if (course == null) {
            return null;
        }
        SimpleCourseDTO dto = new SimpleCourseDTO();
        dto.setId(course.getId());
        dto.setSubject(course.getSubject());
        dto.setPeriods(course.getPeriods().stream()
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
