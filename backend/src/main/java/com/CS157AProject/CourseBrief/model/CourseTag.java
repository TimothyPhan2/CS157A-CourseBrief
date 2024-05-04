package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagID;
@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CourseTag")
public class CourseTag {
    @EmbeddedId
    private CourseTagID id;
    
    @ManyToOne
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "tagID", insertable = false, updatable = false)
    private Tag tag;
}
