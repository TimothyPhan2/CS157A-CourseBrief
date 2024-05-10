package com.CS157AProject.CourseBrief.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.CS157AProject.CourseBrief.model.Comment;
import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.repository.CommentRepository;
import com.CS157AProject.CourseBrief.repository.CourseRepository;
import com.CS157AProject.CourseBrief.service.CommentService;
import com.CS157AProject.CourseBrief.service.CourseService;

@RestController
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourseByCourseId(id);
    }

    @PostMapping("/comments")
    public Comment saveComment(@RequestBody Comment comment) {
        // Fetch the existing Course entity

        Course course = courseRepository.findCourseByCourseID(comment.getCourse().getCourseID());
        comment.setCourse(course);
        
        return commentService.saveComment(comment);
    }

}
