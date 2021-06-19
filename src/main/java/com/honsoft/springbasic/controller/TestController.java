package com.honsoft.springbasic.controller;

import java.util.Map;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;

@Controller
public class TestController {

	@Autowired
	ApplicationContext context;

	@RequestMapping(value = "/testannotation")
	@ResponseBody
	public String handleRequest() {
		Map<String, HandlerAdapter> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context,
				HandlerAdapter.class, true, false);

		matchingBeans.forEach((k, v) -> System.out.printf("%s=%s%n", k, v.getClass().getSimpleName()));
		return "response from /test";
	}

	public void printMessage() {
		// RequestMappingHandlerAdapter
		System.out.println("----- test controller message ------");
	}

	@RequestMapping(value = "/listBeans")
	@ResponseBody
	public String listBeans() {

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
		return allBeans.keySet().toArray().toString();
	}
}