package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.ActionTag;

@Repository
public interface ActionTagRepository extends JpaRepository<ActionTag, String> {
    ActionTag findActionTagsByActionID(String actionID);
    
    
}
