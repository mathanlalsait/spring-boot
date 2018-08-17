package com.candidjava.spring.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@SuppressWarnings("serial")
@Document(collection = "user")
public class User  extends BaseEntity{

	
	private String country;
	
	private String name;
	
	public User(){
		
	}
	public User(String country, String name){
		this.country = country;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
