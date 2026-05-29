package com.shecanfoundation.backend.controller;

import com.shecanfoundation.backend.entity.JoinForm;
import com.shecanfoundation.backend.service.JoinFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form")
@CrossOrigin(origins = "*")

@Controller
public class JoinFormController {

    @Autowired
    private JoinFormService joinFormService;

    @PostMapping("/submit")
    public JoinForm submitForm(@RequestBody JoinForm joinForm) {

        return joinFormService.saveForm(joinForm);
    }
}
