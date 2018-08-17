package com.candidjava.spring.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Profile("user")
public class UserController {
	@RequestMapping("/user")
	public ModelAndView welcomeMessage()
	{
		ModelAndView model = new ModelAndView("view");
		model.addObject("msg","Welcome User!!");
		return model;
	}

}
