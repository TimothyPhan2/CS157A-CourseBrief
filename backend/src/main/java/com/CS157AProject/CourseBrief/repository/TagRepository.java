package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String>{
    
    Tag findTagByTagID(String tagID);
    
    
}
