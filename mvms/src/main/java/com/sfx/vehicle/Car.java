package com.sfx.vehicle;

import com.sfx.mp.MaintenanceProcedure;

public class Car extends Vehicle {
	
	public Car() {
	}
	
	public Car(String model, String make, Integer year, Double price) {
		super(model, make, year, price);
	}

	@Override
	public int calculateMaintenancePrice(MaintenanceProcedure maintanenceProcedure) {
		return maintanenceProcedure.procedureCharge();
	}

}
