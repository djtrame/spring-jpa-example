package com.trame.spring_jpa_example.services.impl;

import com.trame.spring_jpa_example.entities.StudentCourseEntity;
import com.trame.spring_jpa_example.repositories.StudentCourseRepository;
import com.trame.spring_jpa_example.services.StudentCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private StudentCourseRepository studentCourseRepository;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public StudentCourseEntity save(StudentCourseEntity studentCourseEntity) {
        return studentCourseRepository.save(studentCourseEntity);
    }

    @Override
    public List<StudentCourseEntity> findAll() {
        return StreamSupport.stream(studentCourseRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
