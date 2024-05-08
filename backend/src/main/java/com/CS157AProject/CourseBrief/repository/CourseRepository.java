package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.Course;

@Repository
public interface CourseRepository extends JpaRepository <Course, String> {

    Course findCourseByCourseID(String courseID);

    @Query("SELECT c FROM Course c WHERE c.aClass.classID = :classID AND c.professor.professorID = :professorID")
    Course findCourseByClassIDAndProfessorID(@Param("classID")String classID, @Param("professorID")String professorID);

    boolean existsByCourseID(String courseID); 

    /* @Query("SELECT MAX(c.courseID) FROM Course c")
    String findHighestCourseId(); */

    @Query(value = "SELECT MAX(CAST(SUBSTRING(c.courseID, :startPos) AS UNSIGNED)) FROM Course c", nativeQuery = true)
    Integer findHighestCourseId(@Param("startPos") int startPos);

    
}
