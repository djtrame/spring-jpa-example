package com.trame.spring_jpa_example.services.impl;

import com.trame.spring_jpa_example.entities.CourseEntity;
import com.trame.spring_jpa_example.repositories.CourseRepository;
import com.trame.spring_jpa_example.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseEntity save(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }

    @Override
    public List<CourseEntity> findAll() {
        return StreamSupport.stream(courseRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
