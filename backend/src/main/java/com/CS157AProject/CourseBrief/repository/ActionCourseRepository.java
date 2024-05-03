package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.ActionCourse;

@Repository
public interface ActionCourseRepository extends JpaRepository<ActionCourse, String>{
    ActionCourse findActionCourseByActionID(String actionID);
    
    

}
