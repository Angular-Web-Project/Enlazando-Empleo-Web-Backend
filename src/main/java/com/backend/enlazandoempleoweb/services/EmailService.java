package com.backend.enlazandoempleoweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendEmail() {
		
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("salinasedisoncruz@gmail.com");
		message.setTo("salinasedisoncruz@gmail.com");
		message.setSubject("Prueba de envio simple");
		message.setText("Este es el contenido");
		
		javaMailSender.send(message);
	}

}