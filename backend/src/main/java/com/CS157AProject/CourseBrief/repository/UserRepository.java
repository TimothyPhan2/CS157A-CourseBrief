package com.CS157AProject.CourseBrief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.CS157AProject.CourseBrief.model.User;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT a FROM User a WHERE a.userID = :userID")
    User findUserByUserID(String userID);

    @Query("SELECT a FROM User a WHERE a.email = :email")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT a FROM User a WHERE a.username = :username")
    Optional<User> findUserByUsername(String username);

}
