package com.sfx.mp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.vehicle.Vehicle;

public class OilChangeProcedure implements MaintenanceProcedure {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OilChangeProcedure.class);

	@Override
	public void performProcedure(Vehicle vehicle) {
		LOGGER.info("Performed oil change procedure at {}", vehicle.getModel());
	}

	@Override
	public int procedureCharge() {
		return 1000;
	}

}
