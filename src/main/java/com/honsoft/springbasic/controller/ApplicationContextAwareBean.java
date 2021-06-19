package com.honsoft.springbasic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

public class ApplicationContextAwareBean implements ApplicationContextAware {
	private List<Object> beans;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(//
		// context, GenericDAO.class);
		// logger.info("[jade-plugin-sql] found " + beanNames.length + " GenericDAOs: "
		// + Arrays.toString(beanNames));
		// }

		Map<String, Object> allBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, Object.class, true,
				false);
		if (!allBeans.isEmpty()) {
			int cnt=0;
			for (String key : allBeans.keySet()) {
				Object bean = allBeans.get(key);
				boolean orderedType = bean instanceof Ordered ? true : false;
				if (orderedType)
					System.out.println(cnt++ + " "  + key + " : " + bean.getClass().toString() + " , "+ ((Ordered)bean).getOrder());
				else
					System.out.println(cnt++ + " "  + key + " : " + bean.getClass().toString());
			}
			//System.out.println("=================================================");
			//beans = new ArrayList<Object>(allBeans.values());
			//cnt=0;
			//for (Object bean : beans) {
			//	boolean orderedType = bean instanceof Ordered ? true : false;
			//	if (orderedType)
			//		System.out.println(cnt++ + " "  +bean.getClass().toString() + " , "+ ((Ordered)bean).getOrder());
			//	else
			//		System.out.println(cnt++ + " "  +bean.getClass().toString());
			//}
		}
	}
}