package com.candidjava.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity 
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter { 
	@Autowired 
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN"); 
		auth.inMemoryAuthentication().withUser("act").password("act").roles("ACTUATOR"); 
		} 
}