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
import com.sfx.Order;
import com.sfx.User;
import com.sfx.operations.OrderOperations;

public class OrderOperationsTest {
	private Order order;
	private String orderJSON;
	private String orderExclusionJSON;
	private User admin;
	private User user;

	@BeforeEach
	public void setup() throws IOException {
		order = new Order(1L, 500.0, "Wireless mouse");
		Path path = Paths.get("src/main/resources/order.json");
		orderJSON = Files.readAllLines(path).get(0);
		orderExclusionJSON = Files.readAllLines(path).get(1);
		admin = new User(1l, "Danny", "admin");
		user = new User(1l, "Ronny", "user");
	}

	@Test
	public void testConversionOrderToJSON() throws Exception {
		OrderOperations operations = new OrderOperations(admin);
		String json = operations.toJSON(order);
		assertNotNull(json);
		assertEquals(json, orderJSON);
	}

	@Test
	public void testConversionJSONToOrder() throws Exception {
		OrderOperations operations = new OrderOperations(admin);
		Order myOrder = operations.toOrderObject(orderJSON);
		assertNotNull(myOrder);
		assertTrue(myOrder.equals(order));
	}

	@Test
	public void testConversionOrderToJSONWithExclusion() throws Exception {
		OrderOperations operations = new OrderOperations(admin);
		order.setAmount(null);
		String json = operations.toJSON(order);
		assertNotNull(json);
		assertEquals(json, orderExclusionJSON);
	}

	@Test
	public void testConversionJSONToOrderWithExclusion() throws Exception {
		OrderOperations operations = new OrderOperations(admin);
		order.setAmount(null);
		Order myOrder = operations.toOrderObject(orderExclusionJSON);
		assertNotNull(myOrder);
		assertTrue(myOrder.equals(order));
	}

	@Test
	public void testConversionOrderToJSONUser() throws Exception {
		OrderOperations operations = new OrderOperations(user);
		assertThrows(CustomException.class, () -> operations.toJSON(order));
	}

	@Test
	public void testConversionJSONToOrderUser() throws Exception {
		OrderOperations operations = new OrderOperations(user);
		Order myOrder = operations.toOrderObject(orderJSON);
		assertNotNull(myOrder);
		assertTrue(myOrder.equals(order));
	}

	@Test
	public void testConversionOrderToJSONWithExclusionUser() throws Exception {
		OrderOperations operations = new OrderOperations(user);
		order.setAmount(null);
		assertThrows(CustomException.class, () -> operations.toJSON(order));
	}

	@Test
	public void testConversionJSONToOrderWithExclusionUser() throws Exception {
		OrderOperations operations = new OrderOperations(user);
		order.setAmount(null);
		Order myOrder = operations.toOrderObject(orderExclusionJSON);
		assertNotNull(myOrder);
		assertTrue(myOrder.equals(order));
	}
}
