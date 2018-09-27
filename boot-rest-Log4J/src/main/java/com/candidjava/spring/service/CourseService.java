package com.candidjava.spring.service;

import java.util.List;
import java.util.Optional;

import com.candidjava.spring.bean.Course;


public interface CourseService {
	public void createCourse(Course course);
	public List<Course> getCourse();
	public Optional<Course> findById(long id);
	public Course update(Course course, long l);
	public void deleteCourseById(long id);
	public Course updatePartially(Course course, long id);
}
