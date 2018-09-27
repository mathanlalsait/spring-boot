package com.candidjava.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  {

  
	public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "errorhandling");

		SpringApplication.run(Application.class, args);
	}
}
