package com.example.datagateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dtos.CourseDTO;
import com.example.common.dtos.createDTOs.CreateCourseDTO;
import com.example.datagateway.services.interfaces.ICourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private ICourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        if(courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CreateCourseDTO course) {
        CourseDTO createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CreateCourseDTO course, @PathVariable Long id) {
        CourseDTO updatedCourse = courseService.updateCourse(course, id);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Long id) {
        CourseDTO deletedCourse = courseService.deleteCourse(id);
        return ResponseEntity.ok(deletedCourse);
    }

    @PutMapping("/{courseId}/professor/{professorId}")
    public ResponseEntity<CourseDTO> assignProfessorToCourse(@PathVariable Long courseId, @PathVariable Long professorId) {
        CourseDTO resultedCourse = courseService.assignProfessorToCourse(professorId, courseId);
        return ResponseEntity.ok(resultedCourse);
    }
}
