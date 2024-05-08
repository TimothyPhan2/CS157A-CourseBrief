package com.CS157AProject.CourseBriefAdmin.admin.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.CS157AProject.CourseBrief.model.ActionCourse;
import com.CS157AProject.CourseBrief.model.Admin;
import com.CS157AProject.CourseBrief.model.Course;
import com.CS157AProject.CourseBrief.service.ActionCourseService;
import com.CS157AProject.CourseBrief.service.ClassService;
import com.CS157AProject.CourseBrief.service.CourseService;
import com.CS157AProject.CourseBrief.service.CourseTagService;
import com.CS157AProject.CourseBrief.service.ProfessorService;
import com.CS157AProject.CourseBrief.service.StarredCourseService;
import com.CS157AProject.CourseBriefAdmin.admin.helper.InputReader;



//NOTE: This class is meant to create courses ONLY with EXISTING classes and professors.

@ShellComponent
public class CourseCommand {
    private final InputReader inputReader;
    private AdminSecurity adminSecurity;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ClassService classService;

    @Autowired
    private ActionCourseService actionCourseService;

    @Autowired
    private CourseTagService courseTagService;

    @Autowired
    private StarredCourseService starredCourseService;

    @Autowired
    public CourseCommand(InputReader inputReader, AdminSecurity adminSecurity) {
        this.inputReader = inputReader;
        this.adminSecurity = adminSecurity;
    }

    @ShellMethod(key = "course")
    public void courseCommand() {
        String commandType = inputReader
                .prompt("Would you like to add or delete a course? Enter 'add' to add, and 'delete' to delete");
        if (!(commandType.equals("add") || commandType.equals("delete"))) {
            System.out.println("Invalid command. Please enter 'add' or 'delete'.");
            return;
        }
        System.out.println("In order to " + commandType
                + " a course, you must be logged in as an admin. Please enter your credentials.");

        Admin adminLoggedIn = adminSecurity.adminLogin();
    
        if (adminLoggedIn != null) {
            if (commandType.equals("add")) {
                String classID = inputReader.prompt("Enter the classID of the class");
                String profID = inputReader.prompt("Enter the professorID of the professor");
                Course addedCourse = adminAddCourse(classID, profID);
                if (addedCourse != null) {
                    adminActionCourse(addedCourse, adminLoggedIn, "add");
                    return;
                }
            }   else if (commandType.equals("delete")) {
                String classID = inputReader.prompt("Enter the classID of the class");
                String profID = inputReader.prompt("Enter the professorID of the professor");
                Course deletedCourse = adminDeleteCourse(classID, profID);
                if (deletedCourse == null) {
                    adminActionCourse(deletedCourse, adminLoggedIn, "delete");
                    return;
                }
            }
        }
    }

    public Course adminAddCourse(String classID, String profID) {
        if (classService.getClassByClassID(classID) == null) {
            System.out.println("Class does not exist.");
            return null;
        } else if (professorService.getProfessorByProfessorId(profID) == null) {
            System.out.println("Professor does not exist.");
            return null;
        } else if (courseService.getCourseByClassIDAndProfessorID(classID, profID) != null) {
            System.out.println("Course already exists.");
            return null;
        }
        Course course = new Course();
        adminSetCourseID(course);
        course.setAClass(classService.getClassByClassID(classID));
        course.setProfessor(professorService.getProfessorByProfessorId(profID));
        courseService.saveCourse(course);

        System.out.println("Course added successfully.");
        return course;
    }

    public Course adminDeleteCourse(String classID, String profID) {
        if (classService.getClassByClassID(classID) == null) {
            System.out.println("Class does not exist.");
            return null;
        } else if (professorService.getProfessorByProfessorId(profID) == null) {
            System.out.println("Professor does not exist.");
            return null;
        } else if (courseService.getCourseByClassIDAndProfessorID(classID, profID) == null) {
            System.out.println("Course does not exist.");
            return null;
        }
        Course deletedCourse = courseService.getCourseByClassIDAndProfessorID(classID, profID);

        courseTagService.deleteCourseTagsByCourseID(deletedCourse.getCourseID()); //delete course tags associated with course
        starredCourseService.deleteStarredCoursesByCourseID(deletedCourse.getCourseID()); //delete starred courses associated with course
        
        ActionCourse actionCourse = actionCourseService.getActionCourseByCourseID(deletedCourse.getCourseID());
        if (actionCourse != null) {
            actionCourse.setCourse(null); //if AC contains the same course, set course to null
            actionCourseService.saveActionCourse(actionCourse);
        }

        courseService.deleteCourse(courseService.getCourseByClassIDAndProfessorID(classID, profID)); //finally delete course

        System.out.println("Course deleted successfully.");

        return null;
    }

    public void adminSetCourseID(Course course) {
        int numericPart = courseService.getHighestCourseId(7);
        numericPart++;
        String newId = "COURSE" + numericPart;
        course.setCourseID(newId);
    }

    public void adminActionCourse(Course course, Admin admin, String actionType) {
        ActionCourse actionCourse = new ActionCourse();
        adminSetActionCourseID(actionCourse);
        actionCourse.setActionType(actionType);
        actionCourse.setAdmin(admin);
        actionCourse.setCourse(course);
        actionCourseService.saveActionCourse(actionCourse);
    }

    public void adminSetActionCourseID(ActionCourse actionCourse) {
        if (actionCourseService.getHighestActionCourseId() == null) {
            actionCourse.setActionID("AC1");
            return;
        }
        int numericPart = actionCourseService.getHighestActionCourseId(3);
        numericPart++;
        String newId = "AC" + numericPart;
        actionCourse.setActionID(newId);
    }
}
