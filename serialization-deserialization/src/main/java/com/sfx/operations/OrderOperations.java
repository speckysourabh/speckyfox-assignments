package com.sfx.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfx.CustomException;
import com.sfx.Order;
import com.sfx.User;

public class OrderOperations {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderOperations.class);
	private ObjectMapper mapper = new ObjectMapper();
	private User user;
	
	public OrderOperations(User user) {
		super();
		this.user = user;
	}

	public String toJSON(Order order) throws JsonProcessingException, CustomException {
		if(user.getRole().equals("user")) {
			throw new CustomException("Unauthorized access");
		}
		LOGGER.info("Converting order object to order JSON");
		System.out.println(mapper.writeValueAsString(order));
		return mapper.writeValueAsString(order);
	}

	public Order toOrderObject(String json) throws Exception {
		LOGGER.info("Converting order JSON to order Object");
		return mapper.readValue(json, Order.class);
	}

}
