package com.sfx.interaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.pojo.Customer;
import com.sfx.sales.CustomerHandling;

public class CustomerInteraction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHandling.class);

	public void customerInquiry(Customer customer) {
		LOGGER.info("Solving inquiry of customer name - {}", customer.getName());
	}

	public void scheduleTestDerive(Customer customer) {
		LOGGER.info("Schedule test derive for customer name - {}", customer.getName());
	}

	public void maintenanceReminder(Customer customer) {
		LOGGER.info("Maintenance reminder to customer name - {}", customer.getName());
	}

}
