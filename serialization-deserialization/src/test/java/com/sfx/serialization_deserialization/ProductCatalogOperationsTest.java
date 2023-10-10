package com.sfx.serialization_deserialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfx.CustomException;
import com.sfx.Customer;
import com.sfx.Order;
import com.sfx.ProductCatalog;
import com.sfx.User;
import com.sfx.operations.ProductCatalogOperations;

public class ProductCatalogOperationsTest {
	private ProductCatalog productCatalog;
	private String productCatalogJSON;
	private User admin;
	private User user;

	@BeforeEach
	public void setup() throws IOException {
		productCatalog = new ProductCatalog(1l, new Customer(1l, "Sourabh Gautam"),
				new Order(1L, 500.0, "Wireless mouse"));
		Path path = Paths.get("src/main/resources/product-catalog.json");
		productCatalogJSON = Files.readString(path).trim();
		admin = new User(1l, "Danny", "admin");
		user = new User(1l, "Ronny", "user");
	}

	@Test
	public void testConversionProductCatalogToJSON() throws Exception {
		ProductCatalogOperations operations = new ProductCatalogOperations(admin);
		String json = operations.toJSON(productCatalog);
		assertNotNull(json);
		assertEquals(json, productCatalogJSON);
	}

	@Test
	public void testConversionJSONToProductCatalog() throws Exception {
		ProductCatalogOperations operations = new ProductCatalogOperations(admin);
		ProductCatalog myProductCatalog = operations.toObject(productCatalogJSON);
		assertNotNull(myProductCatalog);
		assertTrue(myProductCatalog.equals(productCatalog));
	}
	
	@Test
	public void testConversionProductCatalogToJSONUser() throws Exception {
		ProductCatalogOperations operations = new ProductCatalogOperations(user);
		assertThrows(CustomException.class, () -> operations.toJSON(productCatalog));
	}

	@Test
	public void testConversionJSONToProductCatalogUser() throws Exception {
		ProductCatalogOperations operations = new ProductCatalogOperations(user);
		ProductCatalog myProductCatalog = operations.toObject(productCatalogJSON);
		assertNotNull(myProductCatalog);
		assertTrue(myProductCatalog.equals(productCatalog));
	}
}
