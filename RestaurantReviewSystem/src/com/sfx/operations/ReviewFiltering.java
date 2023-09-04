package com.sfx.operations;

import java.util.List;

import com.sfx.db.Storage;
import com.sfx.pojo.Review;

public class ReviewFiltering {

	public List<Review> getReviewsByUser(Long userId) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getUserId() == userId).toList();
	}

	public List<Review> getReviewByRestaurant(Long restaurantId) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getRestaurantId() == restaurantId).toList();
	}

}
