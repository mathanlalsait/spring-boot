package com.candidjava.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.candidjava.springboot.models.Student;
import com.candidjava.springboot.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/create")
	public void create(@Valid @RequestBody Student student) {
		service.createStudent(student);
	}

	@GetMapping("/getAll")
	public String get(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("students", students);

		return "student";
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable("id") String id, Model model) {
		Student student = service.getStudentById(id);
		return student;
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") String id, @Valid @RequestBody Student student) {
		service.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.service.deleteStudentById(id);
	}
}