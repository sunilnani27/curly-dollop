package com.javacode.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Value;

import com.javacode.spring.service.SportsService;

public class SportsServiceImpl implements SportsService {
	@Value("${EMAIL_ADDRESS}")
	private String emailAddress;
	@Value("${ADDRESS}")
	private String address;

	@Override
	public String playSport() {
		System.out.println("***** Properties *****");
		System.out.println("Email "+emailAddress+" and address is "+ address);
		return "Hi, This is from Sports Service Implementation";
	}

}
