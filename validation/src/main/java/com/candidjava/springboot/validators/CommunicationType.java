package com.candidjava.springboot.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommunicationTypeValidator.class)
@Documented
public @interface CommunicationType {
	String message() default "Communication preference must be email or mobile.";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
