package com.candidjava.spring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.candidjava.spring.entity.User;

@Controller
public class UserController {
	
	@GetMapping("/")
	public ModelAndView register(User user) {
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public ModelAndView create(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("view");
		// user bean will be automatically binded to view refer @ModelAttribute
		System.out.println(user.getName());
			model.addObject("name",user.getName());
			model.addObject("gender",user.getGender());
			model.addObject("email", user.getEmail());
			model.addObject("country", user.getCountry());
			model.addObject("password", user.getPassword());
		return model;
	}

	@GetMapping("/register")
	public ModelAndView viewData(User user) {

		ModelAndView model = new ModelAndView("register");
		return model;
	}

}
