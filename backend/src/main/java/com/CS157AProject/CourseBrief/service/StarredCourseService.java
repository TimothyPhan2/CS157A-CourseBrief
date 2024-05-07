package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.StarredCourse;
import com.CS157AProject.CourseBrief.repository.StarredCourseRepository;


@Service
public class StarredCourseService {
    
    @Autowired
    private StarredCourseRepository starredCourseRepository;

    public StarredCourse saveStarredCourses(StarredCourse starredCourse) {
        return starredCourseRepository.save(starredCourse);
    }


    public StarredCourse getStarredCourseByStarredID(String courseID, String userID) {
        return starredCourseRepository.findStarredCourseByStarredID(courseID, userID);
    }

    public void deleteStarredCoursesByCourseID(String courseID) {
        starredCourseRepository.deleteStarredCourseByCourseId(courseID);
    }
 

    
 

}
