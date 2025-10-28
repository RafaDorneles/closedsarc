package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;

public interface ICourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO createCourse(CreateCourseDTO dto);
    CourseDTO updateCourse(CreateCourseDTO dto, Long id);
    CourseDTO deleteCourse(Long id);
}
