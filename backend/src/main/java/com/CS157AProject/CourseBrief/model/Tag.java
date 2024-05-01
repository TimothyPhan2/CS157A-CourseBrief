package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tag")
@Getter
@Setter
public class Tag {
    
    @Id
    @Column(name = "tagID", nullable = false)
    private String tagID;

    @Column(name= "label", nullable = false)
    private String label;
}
