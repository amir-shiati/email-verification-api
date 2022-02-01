package com.amirshiati.Emailverification.helper;

import com.amirshiati.Emailverification.config.MailConfig;
import com.amirshiati.Emailverification.config.SmtpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class JavaMailSenderHelper {
    private final SmtpConfig smtpConfig;

    private final MailConfig mailConfig;

    @Autowired
    public JavaMailSenderHelper(SmtpConfig smtpConfig, MailConfig mailConfig) {
        this.smtpConfig = smtpConfig;
        this.mailConfig = mailConfig;
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(smtpConfig.getHost());
        mailSender.setPort(smtpConfig.getPort());

        mailSender.setUsername(smtpConfig.getUsername());
        mailSender.setPassword(smtpConfig.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailConfig.getTransportProtocol());
        props.put("mail.smtp.auth", mailConfig.isSmtpAuth());
        props.put("mail.smtp.starttls.enable", mailConfig.isStarttlsEnable());
        props.put("mail.debug", mailConfig.isDebug());

        return mailSender;
    }

    public void sendEmailWithAttachment(String sendTo, String subject, String htmlText) throws MessagingException {
        JavaMailSender javaMailSender = getJavaMailSender();
        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(sendTo);

        helper.setSubject(subject);

        helper.setText(htmlText, true);

        javaMailSender.send(msg);
    }
}
