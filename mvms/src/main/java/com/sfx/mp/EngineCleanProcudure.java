package com.sfx.mp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.vehicle.Vehicle;

public class EngineCleanProcudure implements MaintenanceProcedure {

	private static final Logger LOGGER = LoggerFactory.getLogger(EngineCleanProcudure.class);

	@Override
	public void performProcedure(Vehicle vehicle) {
		LOGGER.info("Performed engine clean procedure at {}", vehicle.getModel());
	}

	@Override
	public int procedureCharge(Vehicle vehicle) {
		ProcedureChargeCalculator calculator = new ProcedureChargeCalculator(vehicle);
		return calculator.calculate(2000);
	}

}
