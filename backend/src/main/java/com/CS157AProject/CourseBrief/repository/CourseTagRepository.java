package com.CS157AProject.CourseBrief.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.CourseTagID;

import jakarta.transaction.Transactional;

import com.CS157AProject.CourseBrief.model.CourseTag;

@Repository
public interface CourseTagRepository extends JpaRepository<CourseTag, CourseTagID>{

    @Query("SELECT ct FROM CourseTag ct WHERE ct.id.courseID = :courseID AND ct.id.tagID = :tagID")
    CourseTag findCourseTagByCourseTagID(@Param("courseID") String courseID, @Param("tagID") String tagID);


    @Transactional
    @Modifying
    @Query("DELETE FROM CourseTag ct WHERE ct.id.courseID = :courseID")
    void deleteCourseTagByCourseID(@Param("courseID") String courseID); 

    @Transactional
    @Modifying
    @Query("DELETE FROM CourseTag ct WHERE ct.id.tagID = :tagID")
    void deleteCourseTagByTagID(@Param("tagID") String tagID);

    @Query("SELECT ct FROM CourseTag ct WHERE ct.course.courseID = :courseID")
    Set<CourseTag> findByCourseID(String courseID);

    
}
