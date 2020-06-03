package com.candidjava.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.models.Student;
import com.candidjava.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping("/getAll")
	public List<Student> get() {
		return service.getAllStudents();
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable("id") String id) {
		return service.getStudentById(id);
	}

}