package com.candidjava.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
@SpringBootApplication
@ImportResource("classpath:app-config.xml")
public class SpringBootWebApplication 
{  
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootWebApplication.class, args);
    }       
}            