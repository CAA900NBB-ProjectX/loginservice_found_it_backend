package com.projectx.foundit.service;

import com.projectx.foundit.model.User;
import com.projectx.foundit.repository.IUserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
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

    @RabbitListener(queues = "user_request_queue")
    @SendTo("user_reply_queue")
    public User handleUserRequest(int userId) {
        // Fetch user details
        return new User((long) userId, "User_" + userId, "user" + userId + "@example.com");
    }
}
