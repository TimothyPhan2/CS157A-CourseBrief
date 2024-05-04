package com.CS157AProject.CourseBrief.service;

import java.util.List;

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

    
    public Tag getTagByTagID(String tagID) {
        return tagRepository.findTagByTagID(tagID);
    }

    public Tag getTagByLabel(String label) {
        return tagRepository.findTagByLabel(label);
    }

    private List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByLabelContains(String label) {
        return tagRepository.findTagsByLabelContains(label);
    }
}
