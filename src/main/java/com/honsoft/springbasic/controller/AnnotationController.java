package com.honsoft.springbasic.controller;


import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnotationController {
	
	@Autowired
	TestController testController;
	
	@RequestMapping("/path1")
	@ResponseBody
	public String method1(HttpServletRequest req, Model model) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(int i=0;i<cookies.length;i++) {
				String name = cookies[i].getName();
				//if("jsessionid")
				System.out.println(name + " , "+ cookies[i].getValue());
			}
		}
		HttpSession session = req.getSession(true);
		//session.setAttribute("cust_name", "testname");
		
		return "view1";
	}
	
	@RequestMapping("/path2")
	public String method2(Model model) {
		return "view2";
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("called after bean initialization");
	}
}
