package com.CS157AProject.CourseBrief.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "ActionCourse")
public class ActionCourse {
    @Id
    private String actionID;
    @Column(name = "actionType")
    private String actionType;
    @ManyToOne
    @JoinColumn(name = "adminID")
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;
}
