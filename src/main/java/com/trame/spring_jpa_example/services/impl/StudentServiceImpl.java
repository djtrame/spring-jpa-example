package com.trame.spring_jpa_example.services.impl;

import com.trame.spring_jpa_example.entities.StudentEntity;
import com.trame.spring_jpa_example.repositories.StudentRepository;
import com.trame.spring_jpa_example.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentEntity> findAll() {
        return StreamSupport.stream(studentRepository
                .findAll()
                .spliterator(),
                false)
            .collect(Collectors.toList());
    }

    @Override
    public boolean isExists(Integer id) {
        return studentRepository.existsById(id);
    }
}
