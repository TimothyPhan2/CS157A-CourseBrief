package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, String>{
    
    Class findClassByClassID(String classID);

    Class findClassByClassName(String className);
    
    
}
