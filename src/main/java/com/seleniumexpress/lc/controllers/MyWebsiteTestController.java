package com.seleniumexpress.lc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.Info;
import com.seleniumexpress.lc.api.MyWebsiteInfoDTO;

@Controller
public class MyWebsiteTestController {

	@Autowired
	Info serverInfo; // = new Info();
	
	@RequestMapping("/testing")
	public String testModelAttribute(@ModelAttribute("myWebsiteInfoDTO") MyWebsiteInfoDTO myWebsiteInfoDTO) throws IOException {
		
		System.out.println("@RequestMapping : inside testModelAttribute /test");
		
		System.out.println(myWebsiteInfoDTO.getWebsiteName());
		System.out.println(myWebsiteInfoDTO.getWebsiteCategory());
		
		String shouldBeNull = null;
		
		shouldBeNull.charAt(1);
		
		if(1==1) {
			throw new IOException();
		}
		
		System.out.println("ip address of the server is " + serverInfo.getServerIp());
		 		
		return "myindex";
	}
	
}
