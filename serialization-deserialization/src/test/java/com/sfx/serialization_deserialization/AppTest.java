package com.sfx.serialization_deserialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfx.App;
import com.sfx.Order;
import com.sfx.Storage;

public class AppTest {

	private List<Order> orders;

	@BeforeEach
	public void setup() {
		orders = Storage.getInstance().getOrders();
	}

	@Test
	public void testExcludeOrderAmount() throws Exception {
		List<String> serializeOrder = App.serializeOrder(1);
		assertNotEquals(serializeOrder.size(), 0);
	}

}
