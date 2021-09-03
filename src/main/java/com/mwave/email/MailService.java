package com.mwave.email;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@EnableAutoConfiguration
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    EmailTemplateService emailTemplateService;

    public void sendMail() throws MessagingException, TemplateException, IOException {

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("CLIENTE", "Ricardo Ribeiro Gayer");

        String corpo = emailTemplateService.getCorpoEmail(data,"modelo.html");

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
                                             
        helper.setFrom("PoB <from@gmail.com>");
        helper.setTo("Ricardo Gayer <to@gmail.com>");
        String assunto = String.format("%s, temos uma mensagem importante para você","Ricardo Gayer");
        helper.setSubject("Assunto...");
        helper.setText(corpo,true);

        helper.addInline("rightSideImage", new File("/Users/rrgayer/Downloads/email/src/main/resources/images/twitter.png"));

        javaMailSender.send(message);

    }

}
