package com.CS157AProject.CourseBrief.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CourseTag> courseTags = new HashSet<>();
}
