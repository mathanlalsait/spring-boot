package com.candidjava.spring.bean;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "course")
@SuppressWarnings("serial")

public class Course extends BaseEntity{

	

	private String name;
	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
