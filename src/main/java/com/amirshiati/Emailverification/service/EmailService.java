package com.amirshiati.Emailverification.service;

import com.amirshiati.Emailverification.config.CodeConfig;
import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.exception.ApiRequestException;
import com.amirshiati.Emailverification.helper.CodeGeneratorHelper;
import com.amirshiati.Emailverification.helper.JavaMailSenderHelper;
import com.amirshiati.Emailverification.repository.EmailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {

    private final EmailRepository repository;
    private final CodeGeneratorHelper codeGeneratorHelper;
    private final JavaMailSenderHelper mailSenderHelper;
    private final CodeConfig codeConfig;
    private final ObjectMapper objectMapper;


    @Autowired
    public EmailService(EmailRepository repository, CodeGeneratorHelper codeGeneratorHelper, JavaMailSenderHelper mailSenderHelper, CodeConfig codeConfig, ObjectMapper objectMapper) {
        this.repository = repository;
        this.codeGeneratorHelper = codeGeneratorHelper;
        this.mailSenderHelper = mailSenderHelper;
        this.codeConfig = codeConfig;
        this.objectMapper = objectMapper;
    }

    public List<EmailModel> getAll() {
        return repository.findAll();
    }

    public EmailModel sendCode(String email) {
        String code = codeGeneratorHelper.getCode();

        try {
            mailSenderHelper.sendEmailWithAttachment(email, "Test", code);
            LocalDateTime time = LocalDateTime.now();
            EmailModel emailModel = new EmailModel();
            emailModel.setAddress(email);
            emailModel.setCode(code);
            emailModel.setSendTime(time);
            emailModel.setValidTime(time.plusMinutes(codeConfig.getValidForMinutes()));
            return repository.save(emailModel);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    public Optional<EmailModel> getEmail(UUID id) {
        return repository.findById(id);
    }

    public ObjectNode isValid(String email, String code) {
        ObjectNode objectNode = objectMapper.createObjectNode();

        EmailModel emailModel = repository.findFirstByAddressOrderBySendTimeDesc(email);
        boolean valid = emailModel.getCode().equals(code) && LocalDateTime.now().isBefore(emailModel.getValidTime());

        objectNode.put("valid", valid);
        return objectNode;
    }
}
