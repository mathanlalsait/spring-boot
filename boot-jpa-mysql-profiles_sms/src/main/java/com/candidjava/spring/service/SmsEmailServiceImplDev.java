package com.candidjava.spring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sms_dev")
public class SmsEmailServiceImplDev implements SmsEmailService {

	@Override
	public String sendSms(String sms) {
		// TODO Auto-generated method stub
		return "SMS Functionality Not Enable in Dev Environment";
	}

	@Override
	public String sendEmail(String email) {
		// TODO Auto-generated method stub
		return "Email Functionality Not Enable in Dev Environment";
	}
	

}
