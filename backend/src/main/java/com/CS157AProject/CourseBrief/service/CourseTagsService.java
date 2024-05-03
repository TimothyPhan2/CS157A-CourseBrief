package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.CourseTags;
import com.CS157AProject.CourseBrief.repository.CourseTagsRepository;

@Service
public class CourseTagsService {

    @Autowired
    private CourseTagsRepository courseTagsRepository;
    public CourseTags saveCourseTags(CourseTags courseTags) {
        return courseTagsRepository.save(courseTags);
    }

   
    public CourseTags getCourseTagsByCourseTagsID(String courseID, String tagID) {
        return courseTagsRepository.findCourseTagsByCourseTagsID(courseID, tagID);
    }

   


}
