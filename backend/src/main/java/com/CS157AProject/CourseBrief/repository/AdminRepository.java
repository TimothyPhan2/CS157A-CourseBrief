package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Admin;
import org.springframework.data.repository.query.Param;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
    @Query("SELECT a FROM Admin a WHERE a.adminID = :adminID")
    Admin findAdminByAdminID(@Param("adminID") String adminID);

    @Query("SELECT a FROM Admin a WHERE a.username = :username")
    Admin findAdminByUsername(@Param("username")String username);
    
    
}
