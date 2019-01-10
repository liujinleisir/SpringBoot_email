package com.liujinlei.emaildemo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class SendEmail {
    //用于发送邮件
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        try {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("1228493283@qq.com");
            message.setTo("liujinlei_19921214@163.com");
            message.setSubject("测试邮件主题");
            message.setText("测试邮件内容");
            this.mailSender.send(mimeMessage);


            return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}