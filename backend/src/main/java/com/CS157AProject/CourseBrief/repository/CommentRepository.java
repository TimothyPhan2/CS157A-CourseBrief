package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CS157AProject.CourseBrief.model.Comment;

public interface CommentRepository extends JpaRepository <Comment, String>{
    Comment findCommentByCommentID(String commentID);
    
   

}
