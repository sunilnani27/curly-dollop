package com.spring.annotations.beansImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.beans.Sport;
import com.spring.annotations.service.SportService;

@Component
public class Cricket implements Sport {

	// field injection autowired
//	@Autowired
//	@Qualifier("cricketServiceImpl")
	private SportService sportService;

	// Constructor Injection in autowired

	@Autowired
	public Cricket(@Qualifier("footBallServiceImpl") SportService sportService) {
		this.sportService = sportService;
	}

	// setter Injection in autowired
	/*
	 * @Autowired public void setSportService(SportService sportService) {
	 * this.sportService = sportService; }
	 */

	// method injection in autowired
	/*
	 * @Autowired public void anonymousMethod(SportService sportService) {
	 * this.sportService = sportService; }
	 */

	@Override
	public String returnSportName() {
		System.out.println(sportService.getServiceName());
		return "This is Cricket bean";
	}
}
