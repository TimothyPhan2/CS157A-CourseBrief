package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CS157AProject.CourseBrief.model.StarredCourses;

public interface StarredCoursesRepository extends JpaRepository<StarredCourses, String>{

}
