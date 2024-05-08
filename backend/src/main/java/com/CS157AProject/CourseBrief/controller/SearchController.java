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

    @GetMapping("/search/")
    public List<Tag> searchTags(@RequestParam String label) {
        return tagService.getTagsByLabelContains(label);
    }

    @GetMapping("/search/courses")
    public Course searchCourses(@RequestParam String profClass, @RequestParam String professorFirstName, @RequestParam String professorLastName) {
        return courseService.getCourseByClassNameAndProfessorName(profClass, professorFirstName, professorLastName);
    }



}
