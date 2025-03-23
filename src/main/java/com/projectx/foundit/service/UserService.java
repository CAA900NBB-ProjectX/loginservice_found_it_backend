package com.projectx.foundit.service;

import com.projectx.foundit.dto.UserDto;
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

    public User getUserWithId(Integer userId){
        try {
            User userdetails = userRepository.findUserById(userId);
            return new User(userdetails.getId(), userdetails.getUsername(), userdetails.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
        } catch (Exception e) {
            throw new RuntimeException("User is not registered!");
        }
    }

    public User getUserWithUsername(String username){
        try {
            User userdetails = userRepository.findUserByUsername(username);
            return new User(userdetails.getId(), userdetails.getUsername(), userdetails.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
        } catch (Exception e) {
            throw new RuntimeException("User is not registered!");
        }
    }

    public User getUserWitEmail(String email){
        try {
            User userdetails = userRepository.findUserByEmail(email);
            return new User(userdetails.getId(), userdetails.getUsername(), userdetails.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
        } catch (Exception e) {
            throw new RuntimeException("User is not registered!");
        }
    }


    public void updateUserData(UserDto userdetails){
        try {
            User exisingUser = userRepository.findUserByUsername(userdetails.getUsername());
            User user = new User(exisingUser.getId(), exisingUser.getUsername(), exisingUser.getEmail(), userdetails.getAddress1(), userdetails.getAddress2(), userdetails.getPobox(), userdetails.getCity(), userdetails.getProvince(), userdetails.getCountry(), userdetails.getGender(), userdetails.getPhoneno());
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("User data is not updated!");
        }
    }

    public void deleteUser(String username){
        try {
            User exisingUser = userRepository.findUserByUsername(username);
            userRepository.deleteById(exisingUser.getId());
        } catch (Exception e) {
            throw new RuntimeException("User is not Deleted !");
        }
    }



}
