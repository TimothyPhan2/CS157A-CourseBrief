package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    
    @Id
    @Column(name = "classID", nullable = false)
    private String classID;
    
    @Column(name = "className", nullable = false, unique = true)
    private String className;

}
