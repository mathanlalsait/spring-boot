package emailApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/send")
	public void create() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("sample@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
		System.out.println("Mail Sent Successfully...");
	}
}
