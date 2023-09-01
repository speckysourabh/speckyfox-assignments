package com.sfx.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfx.mp.OilChangeProcedure;
import com.sfx.pojo.Customer;
import com.sfx.vehicle.Vehicle;

public class InvoicePrinter {
	private static final Logger LOGGER = LoggerFactory.getLogger(OilChangeProcedure.class);
	
    public void generateInvoice(Customer customer, Vehicle vehicle) {
        LOGGER.info("Generating invoice for " + customer.getName() + " for " + vehicle.getModel());
    }
}
