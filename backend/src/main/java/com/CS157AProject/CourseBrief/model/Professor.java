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

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;
}
