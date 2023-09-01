package com.sfx.vehicle;

import com.sfx.mp.MaintenanceProcedure;

public class Bike extends Vehicle {
	
	public Bike() {
	}

	public Bike(String model, String make, Integer year, Double price) {
		super(model, make, year, price);
	}

	@Override
	public int calculateMaintenancePrice(MaintenanceProcedure maintanenceProcedure) {
		return maintanenceProcedure.procedureCharge();
	}

}
