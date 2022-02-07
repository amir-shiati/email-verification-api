package com.amirshiati.Emailverification;

import com.amirshiati.Emailverification.config.JwtConfig;
import com.amirshiati.Emailverification.entity.User;
import com.amirshiati.Emailverification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    UserRepository users;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtConfig jwtConfig;

    @Override
    public void run(String... args) throws Exception {
        String username = jwtConfig.getUsername();
        String password = jwtConfig.getPassword();
        if (!this.users.findByUsername(username).isEmpty())
            return;

        this.users.save(User.builder()
                .username(username)
                .password(this.passwordEncoder.encode(password))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );
    }
}
