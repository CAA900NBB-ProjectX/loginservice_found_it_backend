package com.projectx.foundit.service;

import com.projectx.foundit.model.User;
import com.projectx.foundit.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserWithUserId(Long userId){
        try {
            User userdetails = userRepository.findUserById(userId);
            return new User(userdetails.getUsername(), userdetails.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
        } catch (Exception e) {
            throw new RuntimeException("User is not registered!");
        }
    }

    public User getUserWitEmail(String email){
        try {
            User userdetails = userRepository.findUserByEmail(email);
            return new User(userdetails.getUsername(), userdetails.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
        } catch (Exception e) {
            throw new RuntimeException("User is not registered!");
        }
    }



}
