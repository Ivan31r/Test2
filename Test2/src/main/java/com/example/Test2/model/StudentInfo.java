package com.example.Test2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students_info")
public class StudentInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_cost")
    private Long courseCost;

    @Column(name = "telephone_number")
    private String telephoneNumber;
}
