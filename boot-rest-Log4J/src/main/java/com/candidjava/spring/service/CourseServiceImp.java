package com.candidjava.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Course;
import com.candidjava.spring.repository.CourseRepository;
import com.candidjava.spring.repository.UserRepository;


@Service
@Transactional
public class CourseServiceImp implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	public void createCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}

	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepository.findAll();
	}

	public Optional<Course> findById(long id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id);
		
	}

	public Course update(Course course, long l) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	public void deleteCourseById(long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
	}

	public Course updatePartially(Course user, long id) {
		// TODO Auto-generated method stub
		Optional<Course> usr = findById(id);
		Course newuser=usr.get();
		return courseRepository.save(newuser);
	}



}
