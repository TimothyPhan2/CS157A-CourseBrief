package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.Class;
import com.CS157AProject.CourseBrief.repository.ClassRepository;

@Service
public class ClassService {
    
    @Autowired
    private ClassRepository classRepository;

    public Class saveClass(Class class_name) {
        return classRepository.save(class_name);
    }
}