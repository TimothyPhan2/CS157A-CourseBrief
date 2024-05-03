package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.StarredCourses;
import com.CS157AProject.CourseBrief.repository.StarredCoursesRepository;


@Service
public class StarredCoursesService {
    
    @Autowired
    private StarredCoursesRepository starredCoursesRepository;

    public StarredCourses saveStarredCourses(StarredCourses starredCourses) {
        return starredCoursesRepository.save(starredCourses);
    }


    public StarredCourses getStarredCoursesByStarredID(String courseID, String userID) {
        return starredCoursesRepository.findStarredCoursesByStarredID(courseID, userID);
    }
 

 

}
