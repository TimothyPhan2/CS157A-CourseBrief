package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.StarredCoursesID;

@Getter
@Setter
@Entity
@Table(name = "StarredCourses")
public class StarredCourses {
    @EmbeddedId
    private StarredCoursesID id;
    @ManyToOne
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;
}
