package com.candidjava.spring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sms_prod")
public class SmsEmailServiceImpl implements SmsEmailService {

	@Override
	public String sendSms(String sms) {
		// TODO Auto-generated method stub
		return "Messege Send : "+sms;
	}

	@Override
	public String sendEmail(String email) {
		// TODO Auto-generated method stub
		return "Email Send : " +email;
	}
	

}
