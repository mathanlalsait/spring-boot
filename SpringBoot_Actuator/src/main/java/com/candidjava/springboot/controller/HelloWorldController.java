package com.candidjava.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMessage(){
		return "Hello World";
	}
}
