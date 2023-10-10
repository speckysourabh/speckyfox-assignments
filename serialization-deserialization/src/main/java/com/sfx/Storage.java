package com.sfx;

import java.util.List;

public class Storage {
	
	private List<Order> orders = List.of(new Order(1L, 500.0, "Wireless mouse"));
	private static Storage storage;
	private Storage() {}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public static Storage getInstance() {
		if(storage == null) {
			storage = new Storage();
		}
		return storage;
	}
	
}
