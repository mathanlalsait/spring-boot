package com.example.ribbonserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	Environment environment;

	@GetMapping("/")
	public String health() {
		String serverPort = environment.getProperty("local.server.port");
		return "I am port: " + serverPort;
	}

	@GetMapping("/backend")
	public String backend() {
		String serverPort = environment.getProperty("local.server.port");
		return "Hello from Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
}
