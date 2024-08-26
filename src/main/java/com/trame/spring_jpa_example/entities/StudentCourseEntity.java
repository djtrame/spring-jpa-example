package com.trame.spring_jpa_example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student_courses")
public class StudentCourseEntity {

    @EmbeddedId
    private StudentCoursePK id = new StudentCoursePK();

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Column
    private Date enrollmentDate;
}
