package com.honsoft.springbasic.controller;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ExampleMain {
  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  MyBean myExampleBean() {
      System.out.println("initializing myExampleBean");
      String[] names = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
              this.applicationContext, MyBean.class, true, false);
      System.out.println(Arrays.toString(names));
      return new MyBean();
  }

  @Bean
	@Lazy
  MyBean myLazyExampleBean() {
      System.out.println("initializing myLazyExampleBean");
      String[] names = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
              this.applicationContext, MyBean.class, true, false);
      System.out.println(Arrays.toString(names));
      return new MyBean();
  }

  public static void main(String[] args) {
      ApplicationContext context =
              new AnnotationConfigApplicationContext(ExampleMain.class);
      System.out.println("-- accessing myExampleBean --");
      Object bean = context.getBean("myExampleBean");
      System.out.println(bean);

      System.out.println("-- accessing myLazyExampleBean --");
       bean = context.getBean("myLazyExampleBean");
      System.out.println(bean);

  }
  
  private static class MyBean{}
  
}