package com.seleniumexpress.lc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.seleniumexpress.lc.api.EmailDTO;
import com.seleniumexpress.lc.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {

	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
	
	@RequestMapping("/sendMail")
	public String sendMail(Model model) {
		
		model.addAttribute("emailDTO", new EmailDTO());
		
		return "send-email-page";
	}
	
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfoDTO") UserInfoDTO userInfoDTO, @ModelAttribute("emailDTO") EmailDTO emailDTO) {

		lcAppEmailService.sendEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(), userInfoDTO.getResult());
		
		return "process-email-page";
	}
}
