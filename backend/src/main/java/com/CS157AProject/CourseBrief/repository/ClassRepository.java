package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, String>{
    
    @Query("SELECT c FROM Class c WHERE c.classID = :classID")
    Class findClassByClassID(@Param("classID") String classID);

    @Query("SELECT c FROM Class c WHERE c.className = :className")
    Class findClassByClassName(@Param("className") String className);
    
}
