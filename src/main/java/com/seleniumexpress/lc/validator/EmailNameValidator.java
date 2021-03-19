package com.seleniumexpress.lc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistrationDTO;

@Component
public class EmailNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmailNameValidator - before Empty Check");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		
		String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
		System.out.println("EmailNameValidator - before Email Check - email : "+email);
		if(!email.endsWith("ChristIsLord.com")) {
			System.out.println("EmailNameValidator - inside endsWith() Check");			
			errors.rejectValue("communicationDTO.email", "email.invalidDomain", "Email must end with ChristIsLord.com (from EmailNameValidator");		
//			errors.rejectValue("communicationDTO.email", "email.invalidDomain");
		}
	}

}
