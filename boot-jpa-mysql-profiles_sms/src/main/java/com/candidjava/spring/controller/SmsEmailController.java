package com.candidjava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.spring.service.SmsEmailService;

@RestController
public class SmsEmailController {
	
	@Autowired
	SmsEmailService message;
	
	 @PostMapping(value="/sendsms",headers="Accept=application/json")
	   public String sendSms(@RequestBody String sms) {
		   return message.sendSms(sms);
	   }
	 
	 @PostMapping(value="/sendemail",headers="Accept=application/json")
	   public String sendEmail(@RequestBody String email) {
		   return message.sendEmail(email);
	   }

}
