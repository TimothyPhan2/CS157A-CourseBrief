package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "Course")
public class Course {
    @Id
    private String courseID;
    @ManyToOne
    @JoinColumn(name = "professorID")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "classID")
    private Class aClass;
}
