package com.projectx.foundit.controllers;

import com.projectx.foundit.config.RabbitMQProducer;
import com.projectx.foundit.dto.LoginUserDto;
import com.projectx.foundit.dto.RegisterUserDto;
import com.projectx.foundit.dto.VerifyUserDto;
import com.projectx.foundit.model.User;
import com.projectx.foundit.responses.LoginResponse;
import com.projectx.foundit.service.AuthenticationService;
import com.projectx.foundit.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;


    @Autowired
    private final RabbitMQProducer producer;

    public AthenticationController(JwtService jwtService, AuthenticationService authenticationService, RabbitMQProducer producer) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.producer = producer;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto){
        try {
            User registeredUser = authenticationService.signup(registerUserDto);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserDto loginUserDto){
        try {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
            String jwtToken = jwtService.generateToken(authenticatedUser);
            LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
            return ResponseEntity.ok(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto){
        try {
            authenticationService.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestBody String email){
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }

    @PostMapping("/logout")
    public String logoutUser(@RequestParam String token) {
        producer.logoutUser(message);
        return "User Logout";
    }
}
