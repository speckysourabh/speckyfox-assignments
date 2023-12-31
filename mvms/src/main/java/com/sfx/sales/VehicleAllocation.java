package com.sfx.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.mp.OilChangeProcedure;
import com.sfx.pojo.Customer;
import com.sfx.vehicle.Vehicle;

public class VehicleAllocation {
	private static final Logger LOGGER = LoggerFactory.getLogger(OilChangeProcedure.class);
	public void allocateVehicle(Vehicle vehicle, Customer customer) {
		LOGGER.info("{} allocating to {}", vehicle.getModel(), customer.getName());
	}
}
