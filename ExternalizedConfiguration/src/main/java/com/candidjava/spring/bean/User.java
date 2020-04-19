package com.candidjava.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	private int id;
	private String country;
	private String name;
	public User(){
		id=0;
	}
	public User(int id, String name, String country){
		this.id = id;
		this.name = name;
		this.country = country;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String toString()
	{
		return"name:"+name;
	}

}
