package com.trame.spring_jpa_example.repositories;

import com.trame.spring_jpa_example.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
