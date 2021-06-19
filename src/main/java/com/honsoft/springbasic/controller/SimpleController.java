package com.honsoft.springbasic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleController implements Controller {
	@Autowired
	TestController testController;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		testController.printMessage();
		
		ModelAndView model = new ModelAndView("Greeting");
		model.addObject("message", "Dinesh Madhwal");
		return model;
	}
}