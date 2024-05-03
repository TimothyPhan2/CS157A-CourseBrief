package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Professor")
@Getter
@Setter
public class Professor {
    
    @Id
    @Column(name = "professorID", nullable = false)
    private String professorID;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;
}
