package com.example.admin_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin_service.clients.CourseWebClient;
import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {
    
    @Autowired
    CourseWebClient courseWebClient;

    public Flux<CourseDTO> getAllCourses() {
        return courseWebClient.getAllCourses();
    }

    public Mono<CourseDTO> getCourseById(Long id) {
        return courseWebClient.getCourseById(id);
    }

    public Mono<CourseDTO> createCourse(CreateCourseDTO dto) {
        return courseWebClient.createCourse(dto);
    }

    public Mono<CourseDTO> updateCourse(Long id, CreateCourseDTO dto){
        return courseWebClient.updateCourse(id, dto);
    }

    public Mono<CourseDTO> deleteCourse(Long id) {
        return courseWebClient.deleteCourse(id);
    }

    public Mono<CourseDTO> assignProfessorToCourse(Long professorId, Long courseId){
        return courseWebClient.assignProfessorToCourse(professorId, courseId);
    }
}
