package com.candidjava.springboot.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommunicationTypeValidator implements ConstraintValidator<CommunicationType, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		final List<String> commType = Arrays.asList("email", "mobile");
		return commType.contains(value);
	}

}
