package com.candidjava.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWebApplication { 
	 @RequestMapping("/")
	    @ResponseBody
	    String home() {
	        return "Hello jetty server....!";
	    }
	 
	 
	/* @RequestMapping("/error")
	    @ResponseBody
	    String err() {
	        return "Hello jetty server....!  Sorry some error occured";
	    }
	 */
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
    }      
	
	
	/*@Bean
	public JettyEmbeddedServletContainerFactory  jettyEmbeddedServletContainerFactory() {
	    JettyEmbeddedServletContainerFactory jettyContainer =
	        new JettyEmbeddedServletContainerFactory();
	      
	    jettyContainer.setPort(9000);
	    jettyContainer.setContextPath("/home");
	    return jettyContainer;
	}*/
}            