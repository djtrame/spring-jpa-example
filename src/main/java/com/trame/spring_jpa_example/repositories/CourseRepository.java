package com.trame.spring_jpa_example.repositories;

import com.trame.spring_jpa_example.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
}
