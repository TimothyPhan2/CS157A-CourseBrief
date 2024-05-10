package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String commentID;
    @Column(name = "textualContent")
    private String textualContent;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;
}
