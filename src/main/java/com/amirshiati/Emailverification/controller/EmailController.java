package com.amirshiati.Emailverification.controller;

import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
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

    @PostMapping("/send")
    public EmailModel sendCode(@RequestParam("email") @Email(message = "Invalid email format!") @NotBlank(message = "Email can't be empty!") String email) throws Exception {
        return service.sendCode(email);
    }
}
