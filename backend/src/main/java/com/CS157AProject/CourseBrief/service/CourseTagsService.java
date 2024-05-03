package com.CS157AProject.CourseBrief.service;

import com.CS157AProject.CourseBrief.model.CourseTags;
import com.CS157AProject.CourseBrief.repository.CourseTagsRepository;

public class CourseTagsService {
    private CourseTagsRepository courseTagsRepository;
    public CourseTags saveCourseTags(CourseTags courseTags) {
        return courseTagsRepository.save(courseTags);
    }

}
