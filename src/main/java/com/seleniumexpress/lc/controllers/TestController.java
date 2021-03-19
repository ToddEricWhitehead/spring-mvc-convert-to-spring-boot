package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
//	@ResponseBody
	@RequestMapping("/test1")
	public String sayHello() {
//		return "It Works (sayHello)";
		return "hello-world";
	}
}
