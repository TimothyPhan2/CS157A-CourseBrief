package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagsID;

import com.CS157AProject.CourseBrief.model.CourseTags;

@Repository
public interface CourseTagsRepository extends JpaRepository<CourseTags, CourseTagsID>{

      @Query("SELECT ct FROM CourseTags ct WHERE ct.id.courseID = :courseID AND ct.id.tagID = :tagID")
    CourseTags findCourseTagsByCourseTagsID(@Param("courseID") String courseID, @Param("tagID") String tagID);
    
    
}
