package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.Tag;
import com.CS157AProject.CourseBrief.repository.TagRepository;


@Service
public class TagService {
    
    @Autowired
    private TagRepository tagRepository;
    
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
