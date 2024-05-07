package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

   
    public Course getCourseByCourseId(String courseId) {
        return courseRepository.findCourseByCourseID(courseId);
    }

    public Course getCourseByClassIDAndProfessorID(String classID, String professorID) {
        return courseRepository.findCourseByClassIDAndProfessorID(classID, professorID);
    }

    @Transactional
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    public String getHighestCourseId() {
        return courseRepository.findHighestCourseId();
    }

    public int getHighestCourseId(int startPos) {
        return courseRepository.findHighestCourseId(startPos);
    }
    
}
