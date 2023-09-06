package com.sfx.operations;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import com.sfx.db.Storage;
import com.sfx.pojo.Restaurant;
import com.sfx.pojo.Review;

public class Sorting {

	public List<Review> sortReviewByDateAsc() {
		return Storage.getInstance().getReviews().stream().sorted(Comparator.comparing(Review::getDate)).toList();
	}
	
	public List<Review> sortReviewByDateDesc() {
		return Storage.getInstance().getReviews().stream().sorted(Comparator.comparing(Review::getDate).reversed()).toList();
	}
	
	public TreeMap<Double, Restaurant> displayRestaurantByAverageRating() {
		TreeMap<Double, Restaurant> map = new TreeMap<Double, Restaurant>(Comparator.reverseOrder());
		Analytics analytics = new Analytics();
		Storage.getInstance().getRestaurants().stream().forEach(e -> {
			map.put(analytics.averageRatingOfRestaurant(e.getId()), e);
		});
		return map;
	}
	
}
