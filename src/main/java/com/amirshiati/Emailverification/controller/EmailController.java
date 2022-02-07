package com.amirshiati.Emailverification.controller;

import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

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
    public EmailModel sendCode(@RequestParam("email") @Email(message = "Invalid email format!") @NotBlank(message = "Email can't be empty!") String email) {
        return service.sendCode(email);
    }

    @GetMapping("/email/{id}")
    public EmailModel getEmail(@PathVariable("id") UUID uuid) {
        return service.getEmail(uuid).orElse(null);
    }

    @GetMapping("/validate")
    public ResponseEntity<Object> isValid(@RequestParam("email") @Email(message = "Invalid email format!") @NotBlank(message = "Email can't be empty!") String email,
                                          @RequestParam("code") @NotBlank(message = "Code can't be empty!") String code) {

        return new ResponseEntity<Object>(service.isValid(email, code), HttpStatus.OK);
    }
}
