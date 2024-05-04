package com.CS157AProject.CourseBrief.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
