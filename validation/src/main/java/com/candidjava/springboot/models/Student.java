package com.candidjava.springboot.models;

import javax.validation.constraints.NotEmpty;

import com.candidjava.springboot.validators.CommunicationType;

public class Student {
	private String id;
	@NotEmpty(message = "First name is required")
	private String name;
	private String age;
	@NotEmpty(message = "email is required")
	private String email;
	@NotEmpty(message = "mobile number is required")
	private String mobile;
	@NotEmpty(message = "Communication Type preference is required")
	@CommunicationType
	private String communicationType;

	public Student(String id, String name, String age, String email, String mobile, String communicationType) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.communicationType = communicationType;
	}

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}