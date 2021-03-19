package com.seleniumexpress.lc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException() {
		return "nullpointerexception";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String handleAnyException() {
		return "exception";
	}
}
