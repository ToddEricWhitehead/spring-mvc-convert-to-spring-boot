package com.seleniumexpress.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer //implements WebApplicationInitializer 
{

//	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("my custom initializer onStartup() ------------ Christ is King");
		
		// convert form application-context.xml to java - LoveCalculatorAppConfig
//		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
//		xmlWebApplicationContext.setConfigLocation("classpath:application-context.xml");
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		// create a dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		// register the dispatcher servlet with the servlet context object
		ServletRegistration.Dynamic myCustomDispatcherServlet =  servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
	}

}
