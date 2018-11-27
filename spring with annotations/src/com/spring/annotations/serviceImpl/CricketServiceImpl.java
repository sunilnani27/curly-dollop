package com.spring.annotations.serviceImpl;

import org.springframework.stereotype.Component;

import com.spring.annotations.service.SportService;

@Component
public class CricketServiceImpl implements SportService {
	
	@Override
	public String getServiceName() {
		return "From Cricket service impl";
	}

}
