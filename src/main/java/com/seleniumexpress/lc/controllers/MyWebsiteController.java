package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.lc.api.MyWebsiteInfoDTO;

@Controller
@ControllerAdvice(basePackages = {"com.seleniumexpress.lc.service","com.seleniumexpress.lc.controllers"})
//@ControllerAdvice(assignableTypes = {FirstController.class})
@SessionAttributes("myWebsiteInfoDTO")
public class MyWebsiteController {

	@ModelAttribute("myWebsiteInfoDTO")
	public MyWebsiteInfoDTO getWebsiteInfoDTO() {	
		
		System.out.println("************");
		System.out.println("Constructor - @ModelAttribute : getWebsiteInfoDTO()");		
		
		MyWebsiteInfoDTO myWebsiteInfoDTO = new MyWebsiteInfoDTO();
		myWebsiteInfoDTO.setWebsiteName("seleniumexpress.com");
		myWebsiteInfoDTO.setWebsiteCategory("Education");		
		System.out.println("************");	
		
		return myWebsiteInfoDTO;
	}
	
	@ModelAttribute("header1")
	public String getHeader() {
		System.out.println("------------");
		System.out.println("Constructor - @ModelAttribute('header') ");
		System.out.println("------------");
		return "Selenium Express";
	}

	@RequestMapping("/showInfo")
	public String showWebsiteInfo(@ModelAttribute("myWebsiteInfoDTO") MyWebsiteInfoDTO myWebsiteInfoDTO) {
		System.out.println("@RequestMapping : showInfo() ");

//		myWebsiteInfoDTO.setWebsiteName("### selenium");
//		myWebsiteInfoDTO.setWebsiteCategory("Redemption");
		
		
		System.out.println("showInfo : "+myWebsiteInfoDTO.getWebsiteName());
		System.out.println("showInfo : "+myWebsiteInfoDTO.getWebsiteCategory());

		return "myindex";
	}

	@RequestMapping("/showCompanyInfo")
	public String showCompanyInfo(@ModelAttribute("myWebsiteInfoDTO") MyWebsiteInfoDTO myWebsiteInfoDTO) {
		System.out.println("@RequestMapping : showCompanyInfo()");
		
		System.out.println("showCompanyInfo : "+myWebsiteInfoDTO.getWebsiteName());
		System.out.println("showCompanyInfo : "+myWebsiteInfoDTO.getWebsiteCategory());
		return "myindex";
	}
}
