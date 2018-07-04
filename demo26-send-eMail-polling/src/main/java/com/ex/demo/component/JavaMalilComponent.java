package com.ex.demo.component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class JavaMalilComponent {
    private static final String template = "mail/demomail.ftl";

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        try {
            String text = getTextByTemplate(template, map);
            send(email, text);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String getTextByTemplate(String tpl, Map<String, Object> model) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
        return FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(tpl), model);
    }

    private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        InternetAddress from = new InternetAddress();
        from.setAddress(javaMailSender.getUsername());
        from.setPersonal("demoSendEmail", "UTF-8");
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject("测试邮件");
        helper.setText(text, true);
        javaMailSender.send(message);
        return text;
    }
}