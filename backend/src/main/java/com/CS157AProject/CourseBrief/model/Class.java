package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Class")
@Getter
@Setter
public class Class {
    
    @Id
    @Column(name = "classID", nullable = false)
    private String classID;
    
    @Column(name = "class_name", nullable = false, unique = true)
    private String className;

}
