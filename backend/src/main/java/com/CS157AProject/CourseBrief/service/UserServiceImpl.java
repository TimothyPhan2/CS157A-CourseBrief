package com.CS157AProject.CourseBrief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.User;
import com.CS157AProject.CourseBrief.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

     @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    } 
}
