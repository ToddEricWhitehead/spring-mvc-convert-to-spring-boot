package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.lc.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LCAppServiceImpl;

@Controller
//@RestController
@CrossOrigin(origins = "http://localhost:8081")
@SessionAttributes({"userInfoDTO"})
public class LCAppController {
	
	@Autowired
	private LCAppServiceImpl lcAppService;

	@GetMapping("/")
	public String showHomepage(Model model) {

		model.addAttribute("userInfoDTO", new UserInfoDTO());
		return "home-page";
	}
	
	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO, BindingResult bindingResult) {

		System.out.println("userName : " + userInfoDTO.getUserName());
		System.out.println("crushName : " + userInfoDTO.getCrushName());
		System.out.println("termAndCondition : " + userInfoDTO.isTermAndCondition());
		
		model.addAttribute("userInfoDTO", userInfoDTO);
		
		if (bindingResult.hasErrors() ) {
			System.out.println("!!! form has errors !!!");
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error: allErrors) {
				System.out.println(error);
			}
			
			return "home-page";
		}		
		
		// write a service which will calculate the love % between the userName and the crushName

		String result = lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		model.addAttribute("result", result);
		userInfoDTO.setResult(result);
		
		
		return "result-page";
	}
	
}
