package com.projectx.foundit.controllers;

import com.projectx.foundit.model.User;
import com.projectx.foundit.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class    UserController {
    private final UserService userService;


    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/getuserbyid")
    public ResponseEntity<?> getUser(@RequestParam Long userId){
        try {
            User currentUser = userService.getUserWithId(userId);
            return ResponseEntity.ok(currentUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getuserbyuserid")
    public ResponseEntity<?> getUserByUserId(@RequestParam String userId){
        try {
            User currentUser = userService.getUserWithUserId(userId);
            return ResponseEntity.ok(currentUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getuserbyemail")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        try {
            User currentUser = userService.getUserWitEmail(email);
            return ResponseEntity.ok(currentUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> allUsers(){
        List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }
}
