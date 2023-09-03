package com.sfx.vehicle;

import com.sfx.mp.MaintenanceProcedure;

public abstract class Vehicle {

	private String vehicleType;
	private String model;
	private String make;
	private Integer year;
	private Double price;
	
	public Vehicle() {
	}

	public Vehicle(String vehicleType, String model, String make, Integer year, Double price) {
		super();
		this.vehicleType = vehicleType;
		this.model = model;
		this.make = make;
		this.year = year;
		this.price = price;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", model=" + model + ", make=" + make + ", year=" + year
				+ ", price=" + price + "]";
	}

	public abstract int calculateMaintenancePrice(MaintenanceProcedure maintanenceProcedure);

}
