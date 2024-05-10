package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.CS157AProject.CourseBrief.model.Comment;

public interface CommentRepository extends JpaRepository <Comment, String>{
    @Query("SELECT c FROM Comment c WHERE c.commentID = :commentID")
    Comment findCommentByCommentID(@Param("commentID")String commentID);


}
