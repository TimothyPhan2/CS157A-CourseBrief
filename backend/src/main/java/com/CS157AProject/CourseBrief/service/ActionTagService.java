package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CS157AProject.CourseBrief.model.ActionTag;
import com.CS157AProject.CourseBrief.repository.ActionTagRepository;

@Service
public class ActionTagService {
    @Autowired
    ActionTagRepository actionTagRepository;

    public ActionTag saveActionTag(ActionTag actionTag) {
        return actionTagRepository.save(actionTag);
    }

    public ActionTag getActionTagById(String actionTagID){
        return actionTagRepository.findActionTagsByActionID(actionTagID);
    }

}
