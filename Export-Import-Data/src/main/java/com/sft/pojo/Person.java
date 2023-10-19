package com.sft.pojo;

import java.util.Objects;

public class Person {

	private Long id;
	private String name;
	private Long phone;
	private String address;
	private String gender;
	
	public Person() {
	}

	public Person(Long id, String name, Long phone, String address, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", gender="
				+ gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, gender, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

}
