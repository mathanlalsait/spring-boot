package com.candidjava.spring.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;


@SpringBootApplication
@ComponentScan(basePackages="com.candidjava")
public class Application {

public static void main(String[] args) {
	//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "user");
	SpringApplication.run(Application.class, args);
}
}
