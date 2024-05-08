package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.Admin;
import com.CS157AProject.CourseBrief.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }


    public Admin  getAdminByAdminID(String adminID){
        return adminRepository.findAdminByAdminID(adminID);
    }

    public Admin getAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }

    
}
