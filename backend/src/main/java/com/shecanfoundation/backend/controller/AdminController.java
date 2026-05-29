package com.shecanfoundation.backend.controller;

import com.shecanfoundation.backend.entity.JoinForm;
import com.shecanfoundation.backend.repository.JoinFormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private JoinFormRepository joinFormRepository;

    @GetMapping("/forms")
    public List<JoinForm> getAllForms() {

        return joinFormRepository.findAll();
    }
}