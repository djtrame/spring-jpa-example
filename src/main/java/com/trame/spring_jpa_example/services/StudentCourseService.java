package com.trame.spring_jpa_example.services;

import com.trame.spring_jpa_example.entities.StudentCourseEntity;

import java.util.List;

public interface StudentCourseService {
    StudentCourseEntity save(StudentCourseEntity studentCourseEntity);

    List<StudentCourseEntity> findAll();
}
