package com.candidjava.SpringBootCustomEndPointActuator.controller;

import java.util.Map;

public class CustomHealth {

	private Map<String, Object> healthDetails;

	public void setHealthDetails(Map<String, Object> healthDetails) {
		this.healthDetails = healthDetails;
	}

	public Map<String, Object> getHealthDetails() {
		return this.healthDetails;
	}
}