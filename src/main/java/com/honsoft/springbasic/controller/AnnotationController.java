package com.honsoft.springbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationController {
	
	@Autowired
	TestController testController;
	
	@RequestMapping("/path1")
	public String method1(Model model) {
		return "view1";
	}
	
	@RequestMapping("/path2")
	public String method2(Model model) {
		return "view2";
	}
}
