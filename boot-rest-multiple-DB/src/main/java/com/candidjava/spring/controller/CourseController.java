package com.candidjava.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.Course;
import com.candidjava.spring.service.CourseService;

@RestController
@RequestMapping(value = { "/course" })
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getcourseById(@PathVariable("id") long id) {
		System.out.println("Fetching course with id " + id);
		Optional<Course> optcourse = courseService.findById(id);
		Course course = optcourse.get();
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createcourse(@RequestBody Course course, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating course " + course.getName());
		courseService.createCourse(course);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Course> getAllcourse() {
		List<Course> tasks = courseService.getCourse();
		return tasks;

	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Course> deletecourse(@PathVariable("id") long id) {
		Optional<Course> optcourse = courseService.findById(id);
		Course course = optcourse.get();
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		courseService.deleteCourseById(id);
		return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Course> updatecoursePartially(@PathVariable("id") long id,
			@RequestBody Course currentcourse) {
		Optional<Course> optcourse = courseService.findById(id);
		Course course = optcourse.get();
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		Course usr = courseService.updatePartially(currentcourse, id);
		return new ResponseEntity<Course>(usr, HttpStatus.OK);
	}
}
