package com.candidjava.spring.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Profile({"helloworld","default"})
public class MainController {
	@RequestMapping("/")
	public ModelAndView welcomeMessage()
	{
		System.out.println("sd");
		ModelAndView model = new ModelAndView("view");
		model.addObject("msg","Welcome Hello World !!!");
		return model;
	}
	
}
