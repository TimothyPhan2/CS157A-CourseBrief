package com.CS157AProject.CourseBrief.controller;

import org.springframework.web.bind.annotation.RestController;

import com.CS157AProject.CourseBrief.model.Tag;
import com.CS157AProject.CourseBrief.service.TagService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SearchController {
    
    @Autowired
    private TagService tagService;

    @GetMapping("/search")
    public List<Tag> searchTags(@RequestParam String label) {
        return tagService.getTagsByLabelContains(label);
    }


    // @GetMapping("/search/courses")
    // public Course searchCourses(@RequestParam String profClass, @RequestParam
    // String professorFirstName, @RequestParam String professorLastName) {
    // return courseService.getCourseByClassNameAndProfessorName(profClass,
    // professorFirstName, professorLastName);
    // }

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam(required = false) String profFirstName,
            @RequestParam(required = false) String profLastName, @RequestParam(required = false) String className,
            @RequestParam(required = false) List<String> tagLabel){
        System.out.println("profFirstName from Search Controller: " + profFirstName);
        System.out.println("profLastName from Search Controller: " + profLastName);
        System.out.println("className from Search Controller: " + className);
        System.out.println("tagLabel from Search Controller: " + tagLabel);
        return courseService.getCourseByCriteria(className, profFirstName, profLastName, tagLabel);
    }


}
