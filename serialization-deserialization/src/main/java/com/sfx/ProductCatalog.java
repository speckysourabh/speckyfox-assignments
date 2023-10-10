package com.sfx;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductCatalog implements Serializable {
	@JsonIgnore
	private Long id;
	private Customer customer;
	private Order order;

	public ProductCatalog() {
		super();
	}

	public ProductCatalog(Long id, Customer customer, Order order) {
		super();
		this.id = id;
		this.customer = customer;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCatalog other = (ProductCatalog) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(order, other.order);
	}

}
