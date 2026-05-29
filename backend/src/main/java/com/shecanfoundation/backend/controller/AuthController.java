package com.shecanfoundation.backend.controller;

import com.shecanfoundation.backend.dto.LoginRequest;
import com.shecanfoundation.backend.entity.User;
import com.shecanfoundation.backend.repository.UserRepository;

import com.shecanfoundation.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/auth")

@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if(user == null){

            return ResponseEntity
                    .badRequest()
                    .body("User not found");
        }

        // Temporary plain password check


        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )){

            return ResponseEntity
                    .badRequest()
                    .body("Invalid Password");
        }



        String token =
                jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(token);

    }
}
