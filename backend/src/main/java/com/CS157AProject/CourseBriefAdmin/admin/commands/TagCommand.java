package com.CS157AProject.CourseBriefAdmin.admin.commands;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;

import com.CS157AProject.CourseBriefAdmin.admin.helper.InputReader;

@ShellComponent
public class TagCommand {
    private final InputReader inputReader;

    public TagCommand(InputReader inputReader) {
        this.inputReader = inputReader;
    }
}
