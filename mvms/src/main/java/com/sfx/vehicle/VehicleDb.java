package com.sfx.vehicle;

import java.util.ArrayList;
import java.util.List;

public interface VehicleDb {

	public static List<Vehicle> bikes = List.of(new Bike("Hero Splendor Plus", "Make", 2022, 93000.0));

	public static List<Vehicle> cars = List.of(new Car("Maruti Suzuki Dzire", "Make", 2023, 651000.0));

	public static List<Vehicle> trucks = List.of(new Truck("Eicher Pro", "Make", 2022, 3055000.0));
	
	public static List<Vehicle> getAll(String type) {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		switch(type) {
		case "bike": return bikes;
		case "truck": return trucks;
		case "car": return cars;
		default: return list;
		}
	}
}
 