package com.CS157AProject.CourseBrief.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    
    @Id
    @Column(name = "adminID", nullable = false)
    private String adminID;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "pass_word", nullable = false, unique = true)
    private String pass_word;
}
