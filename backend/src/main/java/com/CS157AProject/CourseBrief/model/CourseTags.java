package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "CourseTags")
public class CourseTags {
    @Id
    private String courseID;
    @Id
    private String tagID;
    @ManyToOne
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "tagID", insertable = false, updatable = false)
    private Tag tag;
}
