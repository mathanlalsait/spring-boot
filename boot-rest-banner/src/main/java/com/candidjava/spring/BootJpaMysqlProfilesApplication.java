package com.candidjava.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candidjava.spring.config.ServerProperties;

@SpringBootApplication
public class BootJpaMysqlProfilesApplication implements CommandLineRunner {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);
    }

	public static void main(String[] args) {
		SpringApplication.run(BootJpaMysqlProfilesApplication.class, args);
	}
}
