package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Professor;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String>{
    
    @Query("SELECT p FROM Professor p WHERE p.professorID = :professorID")
    Professor findProfessorByProfessorID(@Param("professorID") String professorID);

    
   
}
