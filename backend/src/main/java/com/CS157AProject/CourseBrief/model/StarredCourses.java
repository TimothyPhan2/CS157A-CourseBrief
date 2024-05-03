package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "StarredCourses")
public class StarredCourses {
    @Id
    private String courseID;
    @Id
    private String userID;
    @ManyToOne
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;
}
