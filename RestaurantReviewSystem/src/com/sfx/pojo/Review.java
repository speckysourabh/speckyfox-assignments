package com.sfx.pojo;

import java.time.LocalDate;

public class Review {
	private Long id;
	private Long userId;
	private Long restaurantId;
	private Integer rating;
	private String comment;
	private LocalDate date;

	public Review(Long id, Long userId, Long restaurantId, Integer rating, String comment, LocalDate date) {
		super();
		this.id = id;
		this.userId = userId;
		this.restaurantId = restaurantId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
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
		return "Review [id=" + id + ", userId=" + userId + ", restaurantId=" + restaurantId + ", rating=" + rating
				+ ", comment=" + comment + ", date=" + date + "]";
	}

}
