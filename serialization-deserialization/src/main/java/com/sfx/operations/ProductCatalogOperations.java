package com.sfx.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfx.CustomException;
import com.sfx.ProductCatalog;
import com.sfx.User;

public class ProductCatalogOperations {

	private ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderOperations.class);
	private User user;
	
	public ProductCatalogOperations(User user) {
		super();
		this.user = user;
	}

	public String toJSON(ProductCatalog productCatalog) throws JsonProcessingException, CustomException {
		if(user.getRole().equals("user")) {
			throw new CustomException("Unauthorized access");
		}
		LOGGER.info("Converting Product Catalog object to order JSON");
		return mapper.writeValueAsString(productCatalog);
	}

	public ProductCatalog toObject(String json) throws Exception {
		LOGGER.info("Converting Product Catalog JSON to Product Catalog object");
		return mapper.readValue(json, ProductCatalog.class);
	}

}
