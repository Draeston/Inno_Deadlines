package com.innodeadlines.backend.smtp

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class EmailServiceImpl(val emailSender: JavaMailSender) {

    fun sendVerificationMessage(to: String, subject: String, text: String) {
        var message = SimpleMailMessage()
        message.setFrom("innodeadlines@gmail.com")
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)
        emailSender.send(message)
    }

}