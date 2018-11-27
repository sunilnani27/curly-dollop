package com.springcore.practise.interfaceimpl;

import com.springcore.practise.interfaces.Sport;
import com.springcore.practise.service.SportService;

public class FootBall implements Sport {

	private SportService footballService;
	
	

	public SportService getFootballService() {
		return footballService;
	}



	public void setFootballService(SportService footballService) {
		this.footballService = footballService;
	}



	@Override
	public String getSport() {
		System.out.println(footballService.getSportService());
		return "This is from Football Class";
	}

}
