package com.primepro.ims.service;

import com.primepro.ims.config.PasswordUtil;
import com.primepro.ims.model.Registration;
import com.primepro.ims.repository.RegistrationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private JavaMailSender mailSender;


    public Registration save(Registration registration) {
        registration.setPassword(PasswordUtil.hashPassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }
    public Optional<Registration> findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }
    public void sendWelcomeEmail(String email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom("java_primepro@outlook.com");
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("Welcome to IMS Application");
            message.setContent(getHtmlWelcomeEmail(email), "text/html; charset=utf-8");
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to IMS Application");
        message.setText(getHtmlWelcomeEmail(email));
        message.setFrom("java_primepro@outlook.com");*/



    }
    private String getHtmlWelcomeEmail(String userName) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                "  body { font-family: Arial, sans-serif; }" +
                "  .container { padding: 20px; }" +
                "  .header { background-color: #f8f8f8; padding: 10px 20px; text-align: center; }" +
                "  .content { margin: 20px 0; }" +
                "  .footer { background-color: #f8f8f8; padding: 10px 20px; text-align: center; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "  <div class='header'>" +
                "    <h1>Welcome to IMS!</h1>" +
                "  </div>" +
                "  <div class='content'>" +
                "    <p>Dear "+userName+",</p>" +
                "    <p>We are thrilled to have you as part of our community. Here are some quick tips to get you started:</p>" +
                "    <ul>" +
                "      <li>Explore our features: Visit your dashboard to see what we offer.</li>" +
                "      <li>Update your profile: Personalize your account to get the best experience.</li>" +
                "      <li>Connect with us: Follow us on social media and join our community.</li>" +
                "    </ul>" +
                "    <p>If you have any questions, feel free to reach out to our support team at <a href='mailto:support@ims.com'>support@ims.com</a>.</p>" +
                "    <p>Thank you for joining us!</p>" +
                "  </div>" +
                "  <div class='footer'>" +
                "    <p>Best regards,</p>" +
                "    <p>IMS Team</p>" +
                "  </div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
