package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;




import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StarredCourse")
public class StarredCourse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;
}
