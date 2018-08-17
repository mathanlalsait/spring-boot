package com.candidjava.spring.boot.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestController1 {

	
	 @RequestMapping("/user")
	    String home() {
	        return "Hello";
	    }

}
