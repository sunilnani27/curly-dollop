package com.spring.annotations.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;

import com.spring.annotations.service.SportService;

public class StaticClass {

	private static SportService sportService;
	
	@Autowired
	private SportService sportService1;

	@Autowired
	public StaticClass(SportService sportService) {
		sportService = this.sportService1;
	}
	
	public static void randomMethod() {
		sportService.getServiceName();
	}

}
