package com.CS157AProject.CourseBriefAdmin;

import org.jline.reader.LineReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.annotation.*;

import com.CS157AProject.CourseBriefAdmin.admin.helper.InputReader;

@SpringBootApplication(scanBasePackages = {"com.CS157AProject.CourseBriefAdmin", "com.CS157AProject.CourseBrief"})
@CommandScan("admin.commands")
public class CourseBriefAdmin {
    
    @Bean
    public InputReader inputReader(@org.springframework.context.annotation.Lazy LineReader lineReader) {
        return new InputReader(lineReader);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to CourseBrief Admin interface. Please enter a command. Type 'help' for a list of commands.");
        SpringApplication.run(CourseBriefAdmin.class, args);
    }

}
