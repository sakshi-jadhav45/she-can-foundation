package com.shecanfoundation.backend.service;

import com.shecanfoundation.backend.entity.JoinForm;
import com.shecanfoundation.backend.repository.JoinFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinFormService {
    @Autowired
    public JoinFormRepository joinFormRepository;
    public JoinForm saveForm(JoinForm joinForm) {
        return joinFormRepository.save(joinForm);
    }
}
