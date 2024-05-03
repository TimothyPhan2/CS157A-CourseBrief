package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagsID;
@Getter
@Setter
@Data
@Entity
@Table(name = "CourseTags")
public class CourseTags {
    @EmbeddedId
    private CourseTagsID id;
    
    @ManyToOne
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "tagID", insertable = false, updatable = false)
    private Tag tag;
}
