package com.trame.spring_jpa_example.controllers;

import com.trame.spring_jpa_example.entities.CourseEntity;
import com.trame.spring_jpa_example.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "/courses")
    public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseEntity courseEntity) {
        CourseEntity savedCourseEntity = courseService.save(courseEntity);
        return new ResponseEntity<>(savedCourseEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/courses")
    public List<CourseEntity> listCourses() {
        List<CourseEntity> courses = courseService.findAll();
        return courses;
    }
}
