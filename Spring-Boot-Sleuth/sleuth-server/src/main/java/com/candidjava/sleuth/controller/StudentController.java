package com.candidjava.sleuth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.sleuth.models.Student;
import com.candidjava.sleuth.service.StudentService;


@RestController
@RequestMapping("/server/student")
public class StudentController {
	@Autowired
	StudentService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class.getName());

 
    @GetMapping
	public List<Student> get() {
    	  LOGGER.info("Reached Server");
		return service.getAllStudents();
	}
}