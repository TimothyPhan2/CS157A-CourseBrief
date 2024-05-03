package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CS157AProject.CourseBrief.model.Course;

public interface CourseRepository extends JpaRepository <Course, String> {

}
