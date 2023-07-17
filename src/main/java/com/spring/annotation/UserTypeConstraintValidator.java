package com.spring.annotation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserTypeConstraintValidator implements ConstraintValidator<UserType, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> list = Arrays.asList("A","B","C");
		return list.contains(value);
	}

}
