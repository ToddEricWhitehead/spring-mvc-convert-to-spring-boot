package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.CommunicationDTO;
import com.seleniumexpress.lc.api.Phone;
import com.seleniumexpress.lc.api.UserRegistrationDTO;
import com.seleniumexpress.lc.propertyeditor.NamePropertyEditor;
import com.seleniumexpress.lc.validator.EmailNameValidator;
import com.seleniumexpress.lc.validator.UserNameValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmailNameValidator validator;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO) {
//		userRegistrationDTO.setName("Redeemed");
		userRegistrationDTO.setUserName("Healed");
		
		System.out.println("inside showRegistrationPage method");
		
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("2233445566");
		if (userRegistrationDTO.getCommunicationDTO()==null) {
			CommunicationDTO communicationDTO = new CommunicationDTO();
			userRegistrationDTO.setCommunicationDTO(communicationDTO);
		}
		userRegistrationDTO.getCommunicationDTO().setPhone(phone);
		
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto,
			BindingResult result) {
		System.out.println("inside processUserReg -> dto.getName() : |" + dto.getName() +  "|");
		
//		EmailNameValidator validator = new EmailNameValidator();
		((Validator) validator).validate(dto, result);
		
		if(result.hasErrors()) {
			System.out.println("Registration page has errors");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println("error : "+error);
			}
			return "user-registration-page";
		}
		return "registration-success";
	}
	
	@InitBinder("userReg")
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside initBinder method");
		
//		StringTrimmerEditor editor = new StringTrimmerEditor(true);
//		binder.registerCustomEditor(String.class, "name", editor);
		
//		NamePropertyEditor nameEditor = new NamePropertyEditor();
//		binder.registerCustomEditor(String.class, "name", nameEditor);
				
//		NamePropertyEditor nameEditor = new NamePropertyEditor();
//		binder.registerCustomEditor(String.class, nameEditor);		
				
		binder.addValidators(new UserNameValidator());
//		binder.addValidators(new EmailNameValidator());
	}
	
}
