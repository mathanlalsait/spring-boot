package com.candidjava.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.candidjava.springboot.models.Student;
import com.candidjava.springboot.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping("/getAll")
	public String get(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("students", students);

		return "student";
	}

}