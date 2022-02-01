package com.amirshiati.Emailverification.controller;

import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
    private final EmailService service;

    @Autowired
    public EmailController(EmailService service) {
        this.service = service;
    }

    @GetMapping("/emails")
    public List<EmailModel> getAll() {
        return service.getAll();
    }
}
