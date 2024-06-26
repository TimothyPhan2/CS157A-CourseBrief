package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.ActionTag;

@Repository
public interface ActionTagRepository extends JpaRepository<ActionTag, String> {
    @Query("SELECT at FROM ActionTag at WHERE at.actionID = :actionID")
    ActionTag findActionTagByActionID(@Param("actionID") String actionID);
    
    @Query("SELECT MAX(a.actionID) FROM ActionTag a")
    String findHighestActionTagId();

    @Query(value = "SELECT MAX(CAST(SUBSTRING(a.actionID, :startPos) AS UNSIGNED)) FROM action_tag a", nativeQuery = true)
    int findHighestActionTagId(@Param("startPos") int startPos);

    @Query("SELECT a FROM ActionTag a WHERE a.tag.tagID = :tagID")
    ActionTag findActionTagByTag_TagID(@Param("tagID") String tagID);
}
    