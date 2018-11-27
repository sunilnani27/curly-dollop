package com.spring.annotations.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.annotations.beans.Sport;
import com.spring.annotations.beansImpl.Cricket;
import com.spring.annotations.beansImpl.FootBall;


public class MainApp {
	@Value("${email}")
	private static String email;
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("\n*****Cricket*****");
		Sport cricket = context.getBean("cricket", Cricket.class);
		System.out.println(cricket.returnSportName());
		
		System.out.println("\n*****FootBall*****");
		Sport footBall = context.getBean("footBall", FootBall.class);
		System.out.println(footBall.returnSportName());
		
		System.out.println("\n*****property file*****");
		System.out.println(email);
		context.close();
	}
}
