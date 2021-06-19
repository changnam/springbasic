package com.honsoft.springbasic.controller;

import java.util.Map;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;

@Controller
public class TestController {
  
  @Autowired
  ApplicationContext context;
  
  @RequestMapping(value = "/testannotation")
  @ResponseBody
  public String handleRequest () {
      Map<String, HandlerAdapter> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
                context, HandlerAdapter.class, true, false);
      
      matchingBeans.forEach((k, v) -> System.out.printf("%s=%s%n",
                                                        k,
                                                        v.getClass().getSimpleName()));
      return "response from /test";
  }
  
  public void printMessage() {
	  //RequestMappingHandlerAdapter
	  System.out.println("----- test controller message ------");
  }
}