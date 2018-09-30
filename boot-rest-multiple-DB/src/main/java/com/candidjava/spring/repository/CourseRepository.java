package com.candidjava.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, Long>  {

	
	

}
