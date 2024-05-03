package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.EmbeddedIds.StarredCoursesID;
import com.CS157AProject.CourseBrief.model.StarredCourses;

@Repository
public interface StarredCoursesRepository extends JpaRepository<StarredCourses, StarredCoursesID>{

    @Query("SELECT sc FROM StarredCourses sc WHERE sc.id.courseID = :courseID AND sc.id.userID = :userID")
    StarredCourses findStarredCoursesByStarredID(@Param("courseID") String courseID, @Param("userID") String userID);
    
    
}
