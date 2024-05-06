package com.CS157AProject.CourseBrief.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
public class Comment {
    @Id
    private String commentID;
    @Column(name = "textualContent")
    private String textualContent;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;
}
