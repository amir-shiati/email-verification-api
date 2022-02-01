package com.amirshiati.Emailverification.service;

import com.amirshiati.Emailverification.config.CodeConfig;
import com.amirshiati.Emailverification.entity.EmailModel;
import com.amirshiati.Emailverification.helper.CodeGeneratorHelper;
import com.amirshiati.Emailverification.helper.JavaMailSenderHelper;
import com.amirshiati.Emailverification.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    private final EmailRepository repository;
    private final CodeGeneratorHelper codeGeneratorHelper;
    private final JavaMailSenderHelper mailSenderHelper;
    private final CodeConfig codeConfig;


    @Autowired
    public EmailService(EmailRepository repository, CodeGeneratorHelper codeGeneratorHelper, JavaMailSenderHelper mailSenderHelper, CodeConfig codeConfig) {
        this.repository = repository;
        this.codeGeneratorHelper = codeGeneratorHelper;
        this.mailSenderHelper = mailSenderHelper;
        this.codeConfig = codeConfig;
    }

    public List<EmailModel> getAll() {
        return repository.findAll();
    }

    public EmailModel sendCode(String email) throws Exception {
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
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
