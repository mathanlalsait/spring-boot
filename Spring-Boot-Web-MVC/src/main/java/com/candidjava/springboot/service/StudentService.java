package com.candidjava.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.candidjava.springboot.models.Student;
import com.candidjava.springboot.service.StudentService;

@Service
public class StudentService {

	private List<Student> studentList = new ArrayList<Student>(Arrays.asList(

			new Student("1", "ram", "20"), new Student("2", "arun", "21"), new Student("3", "karthick", "22")

	));

	public void createStudent(Student student) {
		studentList.add(student);
	}

	public List<Student> getAllStudents() {
		return studentList;

	}

	public Student getStudentById(String id) {
		return studentList.stream().filter(student -> student.getId().equals(id)).findFirst().get();

	}

	public void updateStudent(String id, Student student) {
		int counter = 0;
		for (Student eachStudent : studentList) {
			if (eachStudent.getId().equals(id)) {
				studentList.set(counter, student);
			}
			counter++;
		}
	}

	public void deleteStudentById(String id) {
		studentList.removeIf(student -> student.getId().equals(id));
	}

}