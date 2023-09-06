package com.sfx.operations;

import java.time.Month;
import java.util.List;

import com.sfx.db.Storage;
import com.sfx.pojo.Restaurant;
import com.sfx.pojo.Review;

public class Search {

	public List<Restaurant> findRestaurantsByKeyword(String keyword) {
		return Storage.getInstance().getRestaurants().stream().filter(e -> e.getName().contains(keyword)).toList();
	}

	public List<Review> findReviewsOfMonth(Month desiredMonth) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getDate().getMonth() == desiredMonth).toList();
	}

	public List<Review> findReviewsOfYear(int desiredYear) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getDate().getYear() == desiredYear).toList();
	}

}
