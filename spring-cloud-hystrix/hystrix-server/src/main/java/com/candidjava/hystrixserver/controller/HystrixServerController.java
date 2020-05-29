package com.candidjava.hystrixserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixServerController {

	@GetMapping("/get-users")
	public String getUserDetails() {
		return "List of Users";
	}
}
