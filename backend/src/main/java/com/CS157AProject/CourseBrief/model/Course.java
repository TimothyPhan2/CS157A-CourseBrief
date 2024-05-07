package com.CS157AProject.CourseBrief.model;

import lombok.*;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

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
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "courseID", nullable = false)
    private String courseID;
    @ManyToOne
    @JoinColumn(name = "professorID")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "classID")
    private Class aClass;
}
