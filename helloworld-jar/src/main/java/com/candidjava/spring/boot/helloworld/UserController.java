package com.candidjava.spring.boot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	
	 @GetMapping("/user")
	    String home() {
	        return "Helloworld";
	    }

}
