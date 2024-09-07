package com.trame.spring_jpa_example.services;

import com.trame.spring_jpa_example.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity save(StudentEntity studentEntity);

    List<StudentEntity> findAll();

    boolean isExists(Integer id);
}
