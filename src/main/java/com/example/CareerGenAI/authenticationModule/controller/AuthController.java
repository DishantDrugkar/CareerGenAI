package com.example.CareerGenAI.authenticationModule.controller;

import com.example.CareerGenAI.authenticationModule.dto.LoginRequest;
import com.example.CareerGenAI.authenticationModule.dto.SignupRequest;
import com.example.CareerGenAI.authenticationModule.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request){
      return authService.signup(request);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
