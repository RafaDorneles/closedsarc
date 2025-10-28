package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.interfaces.ICourseMapper;
import com.example.common.models.Course;
import com.example.common.models.Professor;
import com.example.datagateway.repositories.ICourseRepository;
import com.example.datagateway.repositories.IProfessorRepository;
import com.example.datagateway.services.interfaces.ICourseService;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private ICourseMapper courseMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::entityToDto).toList();
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id).map(courseMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public CourseDTO createCourse(CreateCourseDTO dto) {
        return courseMapper.entityToDto(courseRepository.save(courseMapper.requestToEntity(dto)));
    }

    @Override
    public CourseDTO updateCourse(CreateCourseDTO dto, Long id) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    CourseDTO updatedCourse = courseMapper.entityToDto(courseRepository.save(courseMapper.requestToEntity(dto)));
                    return updatedCourse;
                })
                .orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public CourseDTO deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));
        courseRepository.delete(course);
        return courseMapper.entityToDto(course);
    }

    @Override
    public CourseDTO assignProfessorToCourse(Long professorId, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ApiException("Course not found", HttpStatus.NOT_FOUND));
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ApiException("Professor not found", HttpStatus.NOT_FOUND));

        course.setProfessor(professor);
        courseRepository.save(course);
        return courseMapper.entityToDto(course);
    }
    
}
