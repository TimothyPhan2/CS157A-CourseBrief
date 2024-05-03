package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.StarredCourses;

@Repository
public interface StarredCoursesRepository extends JpaRepository<StarredCourses, String>{

}
