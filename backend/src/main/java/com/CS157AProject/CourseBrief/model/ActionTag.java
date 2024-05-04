package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@Entity
@Table(name = "ActionTag")
public class ActionTag {
    @Id
    private String actionID;
    @Column(name = "actionType")
    private String actionType;
    @ManyToOne
    @JoinColumn(name = "tagID")
    private Tag tag;
    @ManyToOne
    @JoinColumn(name = "adminID")
    private Admin admin;
}

