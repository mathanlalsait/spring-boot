package com.candidjava.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ErrorConfig {
	
	@Value("${error.404}")
	public   String _404 = "Not Found Error";
	@Value("${error.500}")
	public  String _500 = "Internal Server Error";
	@Value("${error.default}")
	public  String DEFAULT_ERROR = "Default Error";



}
