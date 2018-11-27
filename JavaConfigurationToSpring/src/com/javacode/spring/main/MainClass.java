package com.javacode.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javacode.spring.config.ConfigureSpring;
import com.javacode.spring.controller.SportsController;
import com.javacode.spring.logger.SpringCustomLogger;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigureSpring.class, SpringCustomLogger.class);
		SportsController sportsController = context.getBean("getSportController", SportsController.class);
		sportsController.printSport();
		context.close();
	}

}
