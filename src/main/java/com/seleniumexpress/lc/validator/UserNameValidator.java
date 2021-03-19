package com.seleniumexpress.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	// check if UserNameValidator support a given object
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	// custom validation logic
	@Override
	public void validate(Object target, Errors errors) {
		// to check if field is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "User name cannot be empty");		
		
		String userName = ((UserRegistrationDTO)target).getUserName();
		if(!userName.contains("_")) {
//			errors.rejectValue("userName", "userName.invalidString", "Username must contain a '_' underscore");
			errors.rejectValue("userName", "userName.invalidString");
		}
	}

}
