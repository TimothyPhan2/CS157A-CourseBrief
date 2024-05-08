package com.CS157AProject.CourseBriefAdmin.admin.commands;

import org.springframework.shell.standard.ShellMethod;

public class HelpCommand {
    
    @ShellMethod(key = "help")
    public void HelpCommand(){
        System.out.println("Here are the available commands:");
        System.out.println("1. 'tag' - Add or delete a tag");
        System.out.println("2. 'course' - Add or delete a course");
    }
}
