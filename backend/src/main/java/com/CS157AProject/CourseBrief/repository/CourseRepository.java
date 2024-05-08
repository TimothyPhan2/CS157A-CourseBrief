package com.CS157AProject.CourseBrief.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query(value = "SELECT * FROM Course c WHERE c.courseID = :courseID", nativeQuery = true)
    Course findCourseByCourseID(@Param("courseID") String courseID);

    @Query("SELECT c FROM Course c WHERE c.aClass.classID = :classID AND c.professor.professorID = :professorID")
    Course findCourseByClassIDAndProfessorID(@Param("classID") String classID,
            @Param("professorID") String professorID);

    @Query("SELECT c FROM Course c WHERE c.aClass.className = :className AND c.professor.firstName = :professorFirstName AND c.professor.lastName = :professorLastName")
    Course findCourseByClassNameAndProfessorName(@Param("className") String className,
            @Param("professorFirstName") String professorFirstName,
            @Param("professorLastName") String professorLastName);

    boolean existsByCourseID(String courseID);

    /*
     * @Query("SELECT MAX(c.courseID) FROM Course c")
     * String findHighestCourseId();
     */

    @Query(value = "SELECT MAX(CAST(SUBSTRING(c.courseID, :startPos) AS UNSIGNED)) FROM Course c", nativeQuery = true)
    Integer findHighestCourseId(@Param("startPos") int startPos);

    @Query("SELECT ct.course FROM CourseTag ct " +
       "JOIN ct.course c " +
       "JOIN c.professor p " +
       "JOIN c.aClass cl " +
       "WHERE (:className IS NULL OR cl.className = :className) " +
       "AND (:firstName IS NULL OR p.firstName = :firstName) " +
       "AND (:lastName IS NULL OR p.lastName = :lastName) " +
       "AND (:tagLabels IS NULL OR ct.tag.label IN :tagLabels)")
    List<Course> findCoursesByCriteria(@Param("firstName") String firstName, @Param("lastName") String lastName,
            @Param("className") String className, @Param("tagLabels") List<String> tagLabel);
}
