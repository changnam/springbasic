package com.honsoft.springbasic.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleController implements Controller , ApplicationContextAware{
	
	private ApplicationContext context;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> allBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, Object.class, true,
				false);
		if (!allBeans.isEmpty()) {
			int cnt = 0;
			for (String key : allBeans.keySet()) {
				Object bean = allBeans.get(key);
				boolean orderedType = bean instanceof Ordered ? true : false;
				if (orderedType)
					System.out.println(cnt++ + " " + key + " : " + bean.getClass().toString() + " , "
							+ ((Ordered) bean).getOrder());
				else
					System.out.println(cnt++ + " " + key + " : " + bean.getClass().toString());
			}
		}
		
		ModelAndView model = new ModelAndView("Greeting");
		model.addObject("message", "Dinesh Madhwal");
		return model;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("SimpleController called.");
		
	}
}