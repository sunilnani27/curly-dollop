package com.factory.vehileImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.factory.vehile.Vehile;

@Service
@Component
public class Bike implements Vehile {

	@Override
	public String typeOfVehicle() {
		return "This is Bike Implementation class of vehicle interface";
	}

}
