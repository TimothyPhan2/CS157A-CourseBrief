package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CS157AProject.CourseBrief.model.CourseTags;

@Repository
public interface CourseTagsRepository extends JpaRepository<CourseTags, String>{

}
