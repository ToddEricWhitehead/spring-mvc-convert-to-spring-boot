package com.seleniumexpress.lc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SecondController {
	
	@RequestMapping("/normalMethod")
//	public String handlingMethod3(@SessionAttribute("firstName") String firstName, Model model, HttpSession session) {
	public String handlingMethod3(Model model, HttpSession session) {

		String address = (String) session.getAttribute("address") + " Odisha";
		model.addAttribute("address", address);
		System.out.println("SecondControler:: /normalMethod address  : "+address);
		
		session.invalidate();
		
		return "index";
	}

}
