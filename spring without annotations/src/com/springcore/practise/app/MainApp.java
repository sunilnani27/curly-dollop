package com.springcore.practise.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.practise.beans.Hello;
import com.springcore.practise.interfaceimpl.Cricket;
import com.springcore.practise.interfaceimpl.FootBall;
import com.springcore.practise.interfaces.Sport;

public class MainApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Hello hello = context.getBean("demo1", Hello.class);
		System.out.println(hello.sayHello());
		
		System.out.println("***** Constructor Injection *****");		
		Sport cricket = context.getBean("cricket", Cricket.class);
		System.out.println(cricket.getSport());
		
		System.out.println("***** Setter injection *****");		
		Sport footBall = context.getBean("football", FootBall.class);
		System.out.println(footBall.getSport());
		
		context.close();
	}

}
