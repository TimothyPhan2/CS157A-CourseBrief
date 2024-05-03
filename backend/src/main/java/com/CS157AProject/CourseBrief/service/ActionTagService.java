package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.CS157AProject.CourseBrief.model.ActionTag;
import com.CS157AProject.CourseBrief.repository.ActionTagRepository;

public class ActionTagService {
    @Autowired
    ActionTagRepository actionTagRepository;

    public ActionTag saveActionTag(ActionTag actionTag) {
        return actionTagRepository.save(actionTag);
    }

}
