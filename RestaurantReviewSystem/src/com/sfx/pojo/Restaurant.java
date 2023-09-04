package com.sfx.pojo;

public class Restaurant {
	private Long id;
	private String name;
	private String location;
	private String cuisinType;

	public Restaurant(Long id, String name, String location, String cuisinType) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.cuisinType = cuisinType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCuisinType() {
		return cuisinType;
	}

	public void setCuisinType(String cuisinType) {
		this.cuisinType = cuisinType;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", cuisinType=" + cuisinType
				+ "]";
	}

}
