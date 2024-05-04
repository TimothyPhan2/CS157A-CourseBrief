package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.StarredCourseID;
import com.CS157AProject.CourseBrief.model.StarredCourse;

@Repository
public interface StarredCourseRepository extends JpaRepository<StarredCourse, StarredCourseID>{

    @Query("SELECT sc FROM StarredCourse sc WHERE sc.id.courseID = :courseID AND sc.id.userID = :userID")
    StarredCourse findStarredCourseByStarredID(@Param("courseID") String courseID, @Param("userID") String userID);
    
    
}
