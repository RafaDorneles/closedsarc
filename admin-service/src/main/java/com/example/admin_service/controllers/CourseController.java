package com.example.admin_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.admin_service.services.CourseService;
import com.example.common.dtos.CourseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.common.dtos.createDTOs.CreateCourseDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public Flux<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Mono<CourseDTO> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CourseDTO> createCourse(@RequestBody CreateCourseDTO dto) {
        return courseService.createCourse(dto);
    }
    
    @PutMapping("/{id}")
    public Mono<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CreateCourseDTO dto) {
        return courseService.updateCourse(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<CourseDTO> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
