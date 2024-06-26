package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.StarredCourseID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StarredCourse")
public class StarredCourse {
    @EmbeddedId
    private StarredCourseID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;
}
