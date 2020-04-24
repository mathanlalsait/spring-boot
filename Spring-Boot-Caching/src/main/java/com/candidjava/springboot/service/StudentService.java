package com.candidjava.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable("getAllStudents")
	public List<Student> getAllStudents() {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return studentList;

	}

	@Cacheable("getSingleStudent")
	public Student getStudentById(String id) {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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