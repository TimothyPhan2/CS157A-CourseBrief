package com.CS157AProject.CourseBrief.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.Comment;
import com.CS157AProject.CourseBrief.repository.CommentRepository;

@Service
public class CommentService {
     @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        // System.out.println("CommentService: " + comment);
        return commentRepository.save(comment);
    }

    
    public Comment getCommentByCommentID(String commentID) {
        return commentRepository.findCommentByCommentID(commentID);
    }

   
}
