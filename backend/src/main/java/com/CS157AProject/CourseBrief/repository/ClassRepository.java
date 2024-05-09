package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Class;
import org.springframework.data.repository.query.Param;

@Repository
public interface ClassRepository extends JpaRepository<Class, String>{
    @Query("SELECT a FROM Class a WHERE a.classID = :classID")
    Class findClassByClassID(String classID);

    @Query("SELECT a FROM Class a WHERE a.className = :className")
    Class findClassByClassName(String className);
    
    
}
