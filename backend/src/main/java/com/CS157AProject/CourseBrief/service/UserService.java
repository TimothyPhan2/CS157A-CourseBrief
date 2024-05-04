package com.CS157AProject.CourseBrief.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.CS157AProject.CourseBrief.model.User;
import com.CS157AProject.CourseBrief.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Transactional
    public User saveUser(User user){
        if (userRepository.findUserByUserID(user.getUserID()) != null) {
            throw new RuntimeException("User already exists");
        }
        else if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        else if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
