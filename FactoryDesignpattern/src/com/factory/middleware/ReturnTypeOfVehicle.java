package com.factory.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.factory.vehile.Vehile;

@Component
public class ReturnTypeOfVehicle {

	@Autowired()
	@Qualifier("bike")
	@Lazy
	private Vehile bike;

	@Autowired
	@Qualifier("car")
	@Lazy
	private Vehile car;

	@Autowired
	@Qualifier("bus")
	@Lazy
	private Vehile bus;

	public Vehile getVehicle(String vehiclename) {
		if (vehiclename.equalsIgnoreCase("Bike")) {
			return bike;
		} else if (vehiclename.equalsIgnoreCase("Car")) {
			return car;
		} else if (vehiclename.equalsIgnoreCase("Bus")) {
			return bus;
		} else {
			return null;
		}
	}
}
