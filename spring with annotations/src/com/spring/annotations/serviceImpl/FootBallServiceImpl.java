package com.spring.annotations.serviceImpl;

import org.springframework.stereotype.Component;

import com.spring.annotations.service.SportService;

@Component
public class FootBallServiceImpl implements SportService {

	@Override
	public String getServiceName() {
		return "From Football service impl";
	}

}
