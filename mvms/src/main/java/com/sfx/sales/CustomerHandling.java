package com.sfx.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.pojo.Customer;
import com.sfx.vehicle.Vehicle;

public class CustomerHandling {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHandling.class);
	
	public void handleInquiry(Customer customer, Vehicle vehicle) {
		LOGGER.info("Handling inquiry from " + customer.getName() + " about " + vehicle.getModel());
	}
}
