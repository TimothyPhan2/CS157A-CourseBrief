package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.Professor;
import com.CS157AProject.CourseBrief.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }


    public Professor getProfessorByProfessorId(String professorId) {
        return professorRepository.findProfessorByProfessorID(professorId);
    }
    

  
}
