package com.example.CareerGenAI.authenticationModule.service;

import com.example.CareerGenAI.authenticationModule.dto.LoginRequest;
import com.example.CareerGenAI.authenticationModule.dto.SignupRequest;
import com.example.CareerGenAI.authenticationModule.entity.AuthEntity;
import com.example.CareerGenAI.authenticationModule.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;


    public String signup(SignupRequest request){
        AuthEntity existingUser = authRepository.findByEmail(request.email);
        if(existingUser != null){
            return "Email already registered!!!";
        }

        AuthEntity newUser = new AuthEntity();
        newUser.setEmail(request.email);
        newUser.setPassword(request.password);
        newUser.setFirstName(request.firstName);
        newUser.setLastName(request.lastName);
        newUser.setLocation(request.location);

        authRepository.save(newUser);
        return "Signup Successfull !!!";
    }

    public String login(LoginRequest request){
        AuthEntity user = authRepository.findByEmail(request.email);
        if(user == null){
            return "User not found";
        }

        if(!user.getPassword().equals(request.password)){
            return "Invalid password !!";
        }

        return "Login successful ! Welcome " + user.getFirstName();
    }
}
