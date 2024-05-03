package com.CS157AProject.CourseBrief.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.User;
import com.CS157AProject.CourseBrief.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserByUserId(String userId){
        return userRepository.findUserByUserID(userId);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> getUserByUserName(String userName){
        return userRepository.findUserByUsername(userName);
    }
}
