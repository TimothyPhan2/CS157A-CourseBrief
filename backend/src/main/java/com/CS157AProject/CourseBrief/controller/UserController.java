package com.CS157AProject.CourseBrief.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CS157AProject.CourseBrief.model.User;
import com.CS157AProject.CourseBrief.service.UserService;


// Testing to see if the user controller works
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public String user() {
        return "Testing: Welcome User";
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) { // When post request is sent to /signup, it will be in the form of a JSON where a 'User' object will be created
        return userService.saveUser(user);
       
    }
}
