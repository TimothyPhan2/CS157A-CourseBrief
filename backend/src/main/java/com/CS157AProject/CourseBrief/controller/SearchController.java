package com.CS157AProject.CourseBrief.controller;

import org.springframework.web.bind.annotation.RestController;

import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.model.Tag;
import com.CS157AProject.CourseBrief.service.CourseService;
import com.CS157AProject.CourseBrief.service.TagService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SearchController {
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam String profFirstName, @RequestParam String profLastName, @RequestParam String className, @RequestParam List<String> tag) {
        return courseService.getCourseByCriteria(className, profFirstName, profLastName, tag);
    }


}
