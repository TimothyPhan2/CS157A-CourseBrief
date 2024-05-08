package com.CS157AProject.CourseBrief.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.CourseTag;
import com.CS157AProject.CourseBrief.repository.CourseTagRepository;

@Service
public class CourseTagService {

    @Autowired
    private CourseTagRepository courseTagRepository;
    public CourseTag saveCourseTags(CourseTag courseTag) {
        return courseTagRepository.save(courseTag);
    }

    
    public CourseTag getCourseTagsByCourseTagsID(String courseID, String tagID) {
        return courseTagRepository.findCourseTagByCourseTagID(courseID, tagID);
    }

    
    public void deleteCourseTagsByCourseID(String courseID) {
        courseTagRepository.deleteCourseTagByCourseID(courseID);
    }

    public void deleteCourseTagsByTagID(String tagID) {
        courseTagRepository.deleteCourseTagByTagID(tagID);
    }

}
