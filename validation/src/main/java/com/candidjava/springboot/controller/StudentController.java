package com.candidjava.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.springboot.models.Student;
import com.candidjava.springboot.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/create")
	public void create(@Valid @RequestBody Student student) {
		service.createStudent(student);
	}

	@GetMapping("/getAll")
	public List<Student> get() {
		return service.getAllStudents();
	}

	@GetMapping("/get/{id}")
	public Student getById(@PathVariable("id") String id) {
		return service.getStudentById(id);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") String id, @Valid @RequestBody Student student) {
		service.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.service.deleteStudentById(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}