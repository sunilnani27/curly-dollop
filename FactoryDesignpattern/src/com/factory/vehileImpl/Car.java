package com.factory.vehileImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.factory.vehile.Vehile;

@Service
@Component
public class Car implements Vehile {

	@Override
	public String typeOfVehicle() {
		return "This is Car Implementation class of vehicle interface";
	}

}
