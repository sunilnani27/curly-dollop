package com.factory.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.factory.config.VehicleConfiguration;
import com.factory.middleware.ReturnTypeOfVehicle;
import com.factory.vehile.Vehile;

public class AppMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		ReturnTypeOfVehicle returnedVehicle = context.getBean("returnTypeOfVehicle", ReturnTypeOfVehicle.class);
		Vehile vehile = returnedVehicle.getVehicle("Bus");
		System.out.println(vehile.typeOfVehicle());
		context.close();
	}

}
