package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/email/send")
	public ResponseEntity<?> sendEmail() {
		emailService.sendEmail();
		return new ResponseEntity("envio exitoso", HttpStatus.OK);
	}

}
