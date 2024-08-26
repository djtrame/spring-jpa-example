package com.trame.spring_jpa_example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCoursePK implements Serializable {
    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "course_id")
    private Integer course_id;
}
