package com.CS157AProject.CourseBriefAdmin.admin.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.CS157AProject.CourseBrief.model.ActionTag;
import com.CS157AProject.CourseBrief.model.Admin;
import com.CS157AProject.CourseBrief.model.Tag;
import com.CS157AProject.CourseBrief.service.ActionTagService;
import com.CS157AProject.CourseBrief.service.CourseTagService;
import com.CS157AProject.CourseBrief.service.TagService;
import com.CS157AProject.CourseBriefAdmin.admin.helper.InputReader;

@ShellComponent
public class TagCommand {
    private final InputReader inputReader;
    private AdminSecurity adminSecurity;

    @Autowired
    private TagService tagService;

    @Autowired
    private ActionTagService actionTagService;

    @Autowired
    private CourseTagService courseTagService;

    @Autowired
    public TagCommand(InputReader inputReader, AdminSecurity adminSecurity) {
        this.inputReader = inputReader;
        this.adminSecurity = adminSecurity;
    }

    @ShellMethod(key = "tag")
    public void tagCommand(){
        String commandType = inputReader.prompt("Would you like to add or delete a tag? Enter 'add' to add, and 'delete' to delete");
        if (!(commandType.equals("add") || commandType.equals("delete"))) {
            System.out.println("Invalid command. Please enter 'add' or 'delete'.");
            return;
        }
        System.out.println("In order to " + commandType
                + " a tag, you must be logged in as an admin. Please enter your credentials.");
        Admin adminLoggedIn = adminSecurity.adminLogin();
        if (adminLoggedIn != null){
            if (commandType.equals("add")){
                String label = inputReader.prompt("Enter the tag label to add");
                Tag addedTag = adminAddTag(label);
                if (addedTag != null){
                    adminActionTag(addedTag, adminLoggedIn, "add");
                    return;
                }
            }
            else if (commandType.equals("delete")){
                String tagID = inputReader.prompt("Enter the tagID of the tag to delete");
                Tag deletedTag = adminDeleteTag(tagID);
                if (deletedTag == null){
                    adminActionTag(deletedTag, adminLoggedIn, "delete");
                    return;
                }
            }
        }
    }

    public Tag adminAddTag(String label){
        if (tagService.getTagByLabel(label) != null){
            System.out.println("Tag with label " + label + " already exists.");
            return null;
        }
        else if (label.equals("")){
            System.out.println("Tag label cannot be empty.");
            return null;
        }
        Tag tag = new Tag();
        adminSetTagID(tag);
        tag.setLabel(label);
        tagService.saveTag(tag);

        System.out.println("Tag with label '" + label + "' has been added successfully.");
        return tag;

    }


    public Tag adminDeleteTag(String tagID){
        Tag tag = tagService.getTagByTagID(tagID);
        if (tag == null){
            System.out.println("Tag with tagID " + tagID + " does not exist.");
            return null;
        }
        
        courseTagService.deleteCourseTagsByTagID(tagID);
        ActionTag actionTag = actionTagService.getActionTagByTagID(tagID);
        if (actionTag != null){
            actionTag.setTag(null);
            actionTagService.saveActionTag(actionTag);
        }

        tagService.deleteTag(tag);

        System.out.println("Tag with tagID " + tagID + " has been deleted successfully.");
        return null;
    }


    public void adminSetTagID(Tag tag){
        int numericPart = tagService.getHighestTagId(4);
        numericPart++;
        String newId = "TAG" + numericPart;
        tag.setTagID(newId);
    }

    public void adminActionTag(Tag tag, Admin admin, String actionType){
        ActionTag actionTag = new ActionTag();
        adminSetActionTagID(actionTag);
        actionTag.setActionType(actionType);
        actionTag.setAdmin(admin);
        actionTag.setTag(tag);
        actionTagService.saveActionTag(actionTag);
    }

    public void adminSetActionTagID(ActionTag actionTag){
        if (actionTagService.getHighestActionTagId() == null){
            actionTag.setActionID("AT1");
            return;
        }
        int numericPart = actionTagService.getHighestActionTagId(3);
        numericPart++;
        String newId = "AT" + numericPart;
        actionTag.setActionID(newId);
    }
}
