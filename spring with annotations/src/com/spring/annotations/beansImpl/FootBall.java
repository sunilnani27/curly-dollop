package com.spring.annotations.beansImpl;

import org.springframework.stereotype.Component;

import com.spring.annotations.beans.Sport;

@Component
public class FootBall implements Sport {

	@Override
	public String returnSportName() {
		return "From foot ball bean";
	}

}
