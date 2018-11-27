package com.javacode.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.javacode.spring.controller.SportsController;
import com.javacode.spring.service.SportsService;
import com.javacode.spring.serviceImpl.SportsServiceImpl;

@Configuration
@PropertySource("classpath:sport.properties")
public class ConfigureSpring {

	@Bean
	public SportsService getSportServiceImpl() {
		return new SportsServiceImpl();
	}

	@Bean
	public SportsController getSportController() {
		return new SportsController(getSportServiceImpl());
	}
}
