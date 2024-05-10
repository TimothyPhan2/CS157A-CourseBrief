package com.CS157AProject.CourseBrief.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.model.StarredCourse;
import com.CS157AProject.CourseBrief.repository.StarredCourseRepository;
import com.CS157AProject.CourseBrief.model.User;
import com.CS157AProject.CourseBrief.model.Course;

@Service
public class StarredCourseService {
   
    private StarredCourseRepository starredCourseRepository;

    public StarredCourse saveStarredCourses(StarredCourse starredCourse) {

        // starredCourse.setUser(user.get());
        // starredCourse.setCourse(course);
        starredCourse.getId().setCourseID(starredCourse.getUser().getUsername());
        starredCourse.getId().setUserID(starredCourse.getUser().getUsername());
        
        
        
        return starredCourseRepository.save(starredCourse);
    }


    public StarredCourse getStarredCourseByStarredID(String courseID, String userID) {
        return starredCourseRepository.findStarredCourseByStarredID(courseID, userID);
    }
    public List<StarredCourse> getStarredCoursesByUserName(String userName) {
        return starredCourseRepository.findByUsername(userName);
    }
    public void deleteStarredCoursesByCourseID(String courseID) {
        starredCourseRepository.deleteStarredCourseByCourseId(courseID);
    }
 

    
 

}
