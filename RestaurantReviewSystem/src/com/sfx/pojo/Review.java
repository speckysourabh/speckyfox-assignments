package com.sfx.pojo;

import java.time.LocalDate;

public class Review {
	private Long id;
	private User user;
	private Restaurant restaurant;
	private Integer rating;
	private String comment;
	private LocalDate date;

	public Review(Long id, User user, Restaurant restaurant, Integer rating, String comment, LocalDate date) {
		super();
		this.id = id;
		this.user = user;
		this.restaurant = restaurant;
		this.rating = rating;
		this.comment = comment;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user=" + user + ", restaurant=" + restaurant + ", rating=" + rating
				+ ", comment=" + comment + ", date=" + date + "]";
	}
}
