package com.example.zuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClientSideController {

	@RequestMapping("/client/frontend")
	public String welcome() {
		
		return "Server Response :: ";
	}
}
