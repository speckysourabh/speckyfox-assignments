package com.sfx.mp;

import com.sfx.exception.CustomException;
import com.sfx.vehicle.Vehicle;

public class ProcedureChargeCalculator {

	private Vehicle vehicle;

	public ProcedureChargeCalculator(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int calculate(int procedureCharge) {
		
		System.out.println(vehicle);

		int price;
		switch (this.vehicle.getVehicleType()) {
		case "bike": {
			price = procedureCharge;
			break;
		}
		case "car": {
			price = procedureCharge * 2;
			break;
		}
		case "truck": {
			price = procedureCharge * 3;
			break;
		}
		default: {
			throw new CustomException("Vehicle not find");
		}
		}
		return price;
	}

}
