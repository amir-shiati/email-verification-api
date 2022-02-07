package com.amirshiati.Emailverification.controller;

import com.amirshiati.Emailverification.entity.AuthenticationRequest;
import com.amirshiati.Emailverification.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        return ok(authService.signIn(data.getUsername(), data.getPassword()));
    }
}
