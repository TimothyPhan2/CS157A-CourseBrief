package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagID;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "courseID", insertable = false, updatable = false) 
    private Course course;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tagID", insertable = false, updatable = false)
    private Tag tag; 
}
