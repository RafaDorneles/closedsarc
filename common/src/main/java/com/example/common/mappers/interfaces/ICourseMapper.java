package com.example.common.mappers.interfaces;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.common.dtos.simpleDTOs.SimpleCourseDTO;
import com.example.common.models.Course;

public interface ICourseMapper {
    public CourseDTO entityToDto(Course course);
    public Course requestToEntity(CreateCourseDTO roomRequestDTO);
    public SimpleCourseDTO entityToSimpleDto(Course course);
}
