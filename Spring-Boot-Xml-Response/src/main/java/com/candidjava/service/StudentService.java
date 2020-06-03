package com.candidjava.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.candidjava.models.Student;
import com.candidjava.service.StudentService;

@Service
public class StudentService {

	private List<Student> studentList = new ArrayList<Student>(Arrays.asList(

			new Student("1", "ram", "20"), new Student("2", "arun", "21"), new Student("3", "karthick", "22")

	));

	public List<Student> getAllStudents() {
		return studentList;
		
	}

	public Student getStudentById(String id) {
		return studentList.stream().filter(student -> student.getId().equals(id)).findFirst().get();

	}

}