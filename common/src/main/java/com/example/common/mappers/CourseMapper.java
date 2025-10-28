package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;
import com.example.common.mappers.interfaces.ICourseMapper;
import com.example.common.mappers.interfaces.IRentMapper;
import com.example.common.models.Course;

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
        
        dto.setId(course.getId());
        dto.setNumberOfStudents(course.getNumberOfStudents());
        dto.setSubject(course.getSubject());
        dto.setPeriods(course.getPeriods());
        dto.setDays(course.getDays());
        
        if (course.getProfessor() != null) {
            SimpleProfessorDTO simpleProfessor = new SimpleProfessorDTO();
            simpleProfessor.setId(course.getProfessor().getId());
            simpleProfessor.setEmail(course.getProfessor().getEmail());
            simpleProfessor.setName(course.getProfessor().getName());
            dto.setProfessor(simpleProfessor);
        } else {
            dto.setProfessor(null);
        }

        if (course.getRents() != null) {
            dto.setRents(course.getRents().stream()
                        .map(rentMapper::entityToDto)
                        .toList());
        } else {
            dto.setRents(new ArrayList<>());
        }

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
        course.setPeriods(roomRequestDTO.getPeriods());
        course.setDays(roomRequestDTO.getDays());
        course.setRents(new ArrayList<>());

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
        dto.setPeriods(course.getPeriods());
        dto.setDays(course.getDays());
        dto.setNumberOfStudents(course.getNumberOfStudents());
        return dto;
    }
}
