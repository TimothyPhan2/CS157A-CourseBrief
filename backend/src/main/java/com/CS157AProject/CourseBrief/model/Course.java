package com.CS157AProject.CourseBrief.model;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Course")
public class Course {
    
    @Id
    @Column(name = "courseID", nullable = false)
    private String courseID;
    @ManyToOne
    @JoinColumn(name = "professorID")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "classID")
    private Class aClass;


    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CourseTag> courseTags = new HashSet<>();
}
