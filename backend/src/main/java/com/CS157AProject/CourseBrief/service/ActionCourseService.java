package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.ActionCourse;
import com.CS157AProject.CourseBrief.repository.ActionCourseRepository;

@Service
public class ActionCourseService {
   
    @Autowired 
    private ActionCourseRepository actionCourseRepository;

    public ActionCourse saveActionCourse(ActionCourse actionCourse) {
        return actionCourseRepository.save(actionCourse);
    } 
}
