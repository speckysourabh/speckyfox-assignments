package com.sfx.vehicle;

import java.util.Optional;

public class VehicleFactory {

	public static Optional<Vehicle> getVehicle(String vehicle) {
		Optional<Vehicle> obj;
		switch (vehicle) {
		case "bike": {
			obj = Optional.ofNullable(new Bike());
			break;
		}

		case "truck": {
			obj = Optional.ofNullable(new Truck());
			break;
		}
		
		case "car": {
			obj = Optional.ofNullable(new Car());
			break;
		}

		default: {
			obj = Optional.empty();
		}

		}
		return obj;
	}

}
