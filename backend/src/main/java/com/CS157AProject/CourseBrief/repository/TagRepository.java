package com.CS157AProject.CourseBrief.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String>{
    
    @Query("SELECT t FROM Tag t WHERE t.tagID = :tagID")
    Tag findTagByTagID(@Param("tagID")String tagID);

    @Query("SELECT t FROM Tag t WHERE t.label = :label")
    Tag findTagByLabel(@Param("label")String label);

    @Query("SELECT t FROM Tag t WHERE t.label LIKE %:label%")
    List<Tag> findTagsByLabelContains(@Param("label") String label);
    
    @Query(value = "SELECT MAX(CAST(SUBSTRING(t.tagID, :startPos) AS UNSIGNED)) FROM Tag t", nativeQuery = true)
    int findHighestTagId(@Param("startPos") int startPos);
}
