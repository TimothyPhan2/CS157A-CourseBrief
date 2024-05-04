package com.CS157AProject.CourseBrief.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.service.CourseService;

@RestController
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourseByCourseId(id);
    }
}
