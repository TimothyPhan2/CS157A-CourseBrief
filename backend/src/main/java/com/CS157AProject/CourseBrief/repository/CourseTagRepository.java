package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagID;

import com.CS157AProject.CourseBrief.model.CourseTag;

@Repository
public interface CourseTagRepository extends JpaRepository<CourseTag, CourseTagID>{

    @Query("SELECT ct FROM CourseTag ct WHERE ct.id.courseID = :courseID AND ct.id.tagID = :tagID")
    CourseTag findCourseTagByCourseTagID(@Param("courseID") String courseID, @Param("tagID") String tagID);
    
    
}
