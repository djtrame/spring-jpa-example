package com.trame.spring_jpa_example.controllers;

import com.trame.spring_jpa_example.entities.StudentCourseEntity;
import com.trame.spring_jpa_example.services.StudentCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCourseController {

    private StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping(path = "/student-courses")
    public ResponseEntity<StudentCourseEntity> createStudent(@RequestBody StudentCourseEntity studentCourseEntity) {
        StudentCourseEntity savedStudentCourseEntity = studentCourseService.save(studentCourseEntity);
        return new ResponseEntity<>(savedStudentCourseEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/student-courses")
    public List<StudentCourseEntity> listStudentCourses() {
        List<StudentCourseEntity> studentCourses = studentCourseService.findAll();
        return studentCourses;
    }
}

