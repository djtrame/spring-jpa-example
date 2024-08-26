package com.trame.spring_jpa_example.services;

import com.trame.spring_jpa_example.entities.CourseEntity;

import java.util.List;

public interface CourseService {
    CourseEntity save(CourseEntity courseEntity);

    List<CourseEntity> findAll();
}
