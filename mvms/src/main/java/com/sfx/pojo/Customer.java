package com.sfx.pojo;

public class Customer {
	private String name;
	private Long mobNumber;
	private String email;
	private String type;

	public Customer(String name, Long mobNumber, String email, String type) {
		super();
		this.name = name;
		this.mobNumber = mobNumber;
		this.email = email;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(Long mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
