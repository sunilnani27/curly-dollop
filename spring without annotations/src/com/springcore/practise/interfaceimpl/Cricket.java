package com.springcore.practise.interfaceimpl;

import com.springcore.practise.interfaces.Sport;
import com.springcore.practise.service.SportService;

public class Cricket implements Sport {

	private SportService sportService;

	
	public Cricket(SportService sportService) {
		super();
		this.sportService = sportService;
	}


	@Override
	public String getSport() {
		System.out.println(sportService.getSportService());
		return "This is from Cricket Class\n";
	}

}
