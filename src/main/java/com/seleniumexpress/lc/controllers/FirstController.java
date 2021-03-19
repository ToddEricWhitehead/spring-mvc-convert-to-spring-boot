package com.seleniumexpress.lc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"firstName", "lastName"})
public class FirstController {
	
	@RequestMapping("/first")
	public String handingMethod1(Model model, HttpServletRequest request) {
		
		model.addAttribute("firstName", "Todd");
		model.addAttribute("lastName", "Whitehead");
		
		model.addAttribute("next", "/second");

		HttpSession session = request.getSession();
		session.setAttribute("address", "Blr");
		
		return "index";
	}

	@RequestMapping("/second")
	public String handingMethod2(Model model1, SessionStatus status) {
		
		String firstName = (String)model1.getAttribute("firstName");
		System.out.println("/second :: firstName :"+firstName);
		
		String lastName = (String)model1.getAttribute("lastName");
		System.out.println("/second :: lastName : "+lastName);
		
		model1.addAttribute("firstName", firstName);
		model1.addAttribute("lastName", lastName);
		
		model1.addAttribute("next", "/third");
		
//		status.setComplete();
		
		return "index";
	}
	
	@RequestMapping("/third")
	public String handlingMethod3(Model model, SessionStatus status, HttpSession session) {
		
		String lastName = (String)model.getAttribute("lastName");
		model.addAttribute("lastName", lastName);
		System.out.println("/third :: lastName : "+lastName);
		
		model.addAttribute("next", "/normalMethod");
		
		status.setComplete();
		
		String newAddress = (String) session.getAttribute("address") + " Home Sweet Home"; 
		model.addAttribute("address", newAddress);
		
		return "index";
	}
}
