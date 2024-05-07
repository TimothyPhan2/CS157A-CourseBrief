package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.ActionCourse;

@Repository
public interface ActionCourseRepository extends JpaRepository<ActionCourse, String>{
    ActionCourse findActionCourseByActionID(String actionID);
    
    @Query("SELECT MAX(a.actionID) FROM ActionCourse a")
    String findHighestActionCourseId();
    
    @Query(value = "SELECT MAX(CAST(SUBSTRING(a.actionID, :startPos) AS UNSIGNED)) FROM action_course a", nativeQuery = true)
    int findHighestActionCourseId(@Param("startPos") int startPos);

}
