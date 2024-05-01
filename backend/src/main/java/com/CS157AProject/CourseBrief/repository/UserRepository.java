package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
