package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
    Admin findAdminByAdminID(String adminID);

    Admin findAdminByUsername(String username);
    
    
}
