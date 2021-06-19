package com.honsoft.springbasic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.HttpRequestHandler;

public class MyHttpRequestHandler implements HttpRequestHandler {

	private ApplicationContext context;
		
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		PrintWriter writer = response.getWriter();
		writer.write("response from MyHttpRequestHandler, uri: " + request.getRequestURI());

	}
	
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}