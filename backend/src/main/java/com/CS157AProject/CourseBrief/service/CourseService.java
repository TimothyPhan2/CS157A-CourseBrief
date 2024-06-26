package com.CS157AProject.CourseBrief.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.repository.CourseRepository;
import com.CS157AProject.CourseBrief.repository.CourseTagRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseTagRepository courseTagRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

   
    public Course getCourseByCourseId(String courseId) {
        return courseRepository.findCourseByCourseID(courseId);
    }

    public Course getCourseByClassIDAndProfessorID(String classID, String professorID) {
        return courseRepository.findCourseByClassIDAndProfessorID(classID, professorID);
    }


    public Course getCourseByClassNameAndProfessorName(String className, String professorFirstName, String professorLastName) {
        return courseRepository.findCourseByClassNameAndProfessorName(className, professorFirstName, professorLastName);
    }

    public Set<Course> getCourseByCriteria(String className, String profFirstName, String profLastName, List<String> tagLabels) {
        // List<Course> courses = courseRepository.findCoursesByCriteria(profFirstName, profLastName, className, tagLabels);
        Set<Course> courses = courseRepository.findCoursesByCriteria(profFirstName, profLastName, className, tagLabels);
        setCoursesWithCourseTags(courses);
        return courses;
    }
    

    public void setCoursesWithCourseTags(Set<Course> courses){
        for (Course course : courses) {
            course.setCourseTags(courseTagRepository.findByCourseID(course.getCourseID()));
        }
    }


    @Transactional
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    /* public String getHighestCourseId() {
        return courseRepository.findHighestCourseId();
    } */

    public int getHighestCourseId(int startPos) {
        return courseRepository.findHighestCourseId(startPos);
    }
    
}
