package com.CS157AProject.CourseBrief.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

        Course findCourseByCourseID(String courseID);

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

        // @Query("SELECT ct.course FROM CourseTag ct " +
        // "JOIN ct.course c " +
        // "JOIN c.professor p " +
        // "JOIN c.aClass cl " +
        // "WHERE (:className IS NULL OR cl.className = :className) " +
        // "AND (:firstName IS NULL OR p.firstName = :firstName) " +
        // "AND (:lastName IS NULL OR p.lastName = :lastName) " +
        // "AND (:tagLabels IS NULL OR ct.tag.label IN :tagLabels)")
        // List<Course> findCoursesByCriteria(@Param("firstName") String firstName,
        // @Param("lastName") String lastName,
        // @Param("className") String className, @Param("tagLabels") List<String>
        // tagLabel);

        @Query("SELECT c FROM Course c " +
        "JOIN c.courseTags ct " +
        "JOIN c.professor p " +
        "JOIN c.aClass cl " +
        "WHERE (:className IS NULL OR cl.className = :className) " +
        "AND (:firstName IS NULL OR p.firstName = :firstName) " +
        "AND (:lastName IS NULL OR p.lastName = :lastName) " +
        "AND (:tagLabels IS NULL OR ct.tag.label IN :tagLabels) " +
        "GROUP BY c.courseID " +
        "HAVING COUNT(DISTINCT ct.tag.label) >= (SELECT COUNT(t) FROM Tag t WHERE t.label IN :tagLabels)")
        Set<Course> findCoursesByCriteria(@Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("className") String className, @Param("tagLabels") List<String>
        tagLabels);

       

        // @Query("SELECT c, t.label as tagLabel FROM Course c " +
        //                 "JOIN c.courseTags ct " +
        //                 "JOIN ct.tag t " + // Directly join with the Tag entity
        //                 "JOIN c.professor p " +
        //                 "JOIN c.aClass cl " +
        //                 "WHERE (:className IS NULL OR cl.className = :className) " +
        //                 "AND (:firstName IS NULL OR p.firstName = :firstName) " +
        //                 "AND (:lastName IS NULL OR p.lastName = :lastName) " +
        //                 "AND (:tagLabels IS NULL OR t.label IN :tagLabels) " +
        //                 "GROUP BY c.courseID, t.label " + // Include tag.label in the GROUP BY clause
        //                 "HAVING COUNT(DISTINCT t.label) >= (SELECT COUNT(t) FROM Tag t WHERE t.label IN :tagLabels)")
        // List<Course> findCoursesByCriteria(@Param("firstName") String firstName, @Param("lastName") String lastName,
        //                 @Param("className") String className, @Param("tagLabels") List<String> tagLabels);
}
