package com.CS157AProject.CourseBriefAdmin.admin.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.CS157AProject.CourseBrief.model.Admin;
import com.CS157AProject.CourseBrief.service.AdminService;
import com.CS157AProject.CourseBriefAdmin.admin.helper.InputReader;

@Component
public class AdminSecurity {
    private final InputReader inputReader;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    protected boolean loggedIn = false;
    protected Admin loggedInAdmin = null;

    @Autowired
    public AdminSecurity(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Autowired
    private AdminService adminService;

    public boolean login() {
        boolean loggedIn = false;
        String username = inputReader.prompt("Enter your username");
        String password = inputReader.prompt("Enter your password");
        if (adminService.getAdminByUsername(username) != null) {
            loggedIn = passwordEncoder.matches(password, adminService.getAdminByUsername(username).getPassword());
        }
        return loggedIn;
    }

    public Admin adminLogin() {
        Admin admin = null;
        String username = inputReader.prompt("Enter your username");
        String password = inputReader.prompt("Enter your password");
        if (adminService.getAdminByUsername(username) != null) {
            if(passwordEncoder.matches(password, adminService.getAdminByUsername(username).getPassword())){
                admin = adminService.getAdminByUsername(username);
                loggedIn = true;
                loggedInAdmin = admin;
            }
            else{
                System.out.println("Incorrect username or password.");}
        }
        return admin;
    }
}