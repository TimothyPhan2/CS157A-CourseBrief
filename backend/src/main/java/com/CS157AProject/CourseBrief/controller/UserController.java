package com.CS157AProject.CourseBrief.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// Testing to see if the user controller works
@RestController
public class UserController {
    @GetMapping("/user")
    public String user() {
        return "Testing: Welcome User";
    }
}
