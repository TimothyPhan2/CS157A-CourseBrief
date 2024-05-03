package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String>{
    
    Professor findProfessorByProfessorID(String professorID);
    
   
}
