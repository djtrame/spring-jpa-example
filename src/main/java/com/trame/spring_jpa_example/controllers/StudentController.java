package com.trame.spring_jpa_example.controllers;

import com.trame.spring_jpa_example.entities.StudentEntity;
import com.trame.spring_jpa_example.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/students")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
        StudentEntity savedStudentEntity = studentService.save(studentEntity);
        return new ResponseEntity<>(savedStudentEntity, HttpStatus.CREATED);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/students")
    public List<StudentEntity> listStudents() {
        List<StudentEntity> students = studentService.findAll();
        return students;
    }

    @PutMapping(path = "/students/{id}")
    public ResponseEntity<StudentEntity> fullUpdateStudent(
            @PathVariable("id") Integer id,
            @RequestBody StudentEntity studentEntity) {

        if(!studentService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        studentEntity.setStudent_id(id); //this is necessary to update the exact entity whose ID was passed into the path variable
        StudentEntity savedStudentEntity = studentService.save(studentEntity);
        return new ResponseEntity<>(savedStudentEntity, HttpStatus.OK);
    }
}
