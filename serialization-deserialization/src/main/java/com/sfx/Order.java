package com.sfx;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Order implements Serializable {
	@JsonIgnore
	private Long id;
	private Double amount;
	private String orderDate;
	private String description;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Order(Long id, Double amount, String orderDate, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.orderDate = orderDate;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, orderDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(description, other.description)
				&& Objects.equals(orderDate, other.orderDate);
	}

	

}
