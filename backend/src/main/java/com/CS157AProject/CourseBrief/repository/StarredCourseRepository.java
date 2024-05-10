package com.CS157AProject.CourseBrief.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.StarredCourseID;

import jakarta.transaction.Transactional;

import com.CS157AProject.CourseBrief.model.StarredCourse;

@Repository
public interface StarredCourseRepository extends JpaRepository<StarredCourse, StarredCourseID>{

    @Query("SELECT sc FROM StarredCourse sc WHERE sc.id.courseID = :courseID AND sc.id.userID = :userID")
    StarredCourse findStarredCourseByStarredID(@Param("courseID") String courseID, @Param("userID") String userID);
    
    @Query("SELECT sc FROM StarredCourse sc WHERE sc.id.userID = :userID")
    List<StarredCourse> findByUsername(@Param("userID") String userID);

    @Transactional
    @Modifying
    @Query("DELETE FROM StarredCourse sc WHERE sc.id.courseID = :courseID")
    void deleteStarredCourseByCourseId(@Param("courseID") String courseID);
}
