package com.amirshiati.Emailverification.service;

import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private final EmailRepository repository;

    @Autowired
    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public List<EmailModel> getAll() {
        return repository.findAll();
    }
}
