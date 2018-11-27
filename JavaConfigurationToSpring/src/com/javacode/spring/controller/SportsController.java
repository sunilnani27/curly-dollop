package com.javacode.spring.controller;

import com.javacode.spring.service.SportsService;

public class SportsController {
	
	private SportsService sportsService;

	public SportsController(SportsService sportsService) {
		super();
		this.sportsService = sportsService;
	}
	
	
	public void printSport() {
		System.out.println(sportsService.playSport());
	}

}
