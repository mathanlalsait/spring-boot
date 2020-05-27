package com.candidjava.hystrixclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public String getUsers() {
		return restTemplate.getForObject("http://localhost:8081/get-users", String.class);
	}
	
	

	public String fallBackMethod() {
		return "No User Found";
	}
	
}
