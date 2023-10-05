package com.sfx.operations;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.sfx.db.Storage;
import com.sfx.pojo.Restaurant;
import com.sfx.pojo.User;
	
public class Analytics {

	public double averageRatingOfRestaurant(Long restaurantId) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getRestaurant().getId() == restaurantId)
				.collect(Collectors.averagingDouble(e -> e.getRating()));
	}

	public List<Restaurant> topFiveMostReviewedRestaurants() {
		Map<Restaurant, Long> restaurantMap = Storage.getInstance().getReviews().stream()
				.collect(Collectors.groupingBy(e -> e.getRestaurant(), Collectors.counting()));
		return restaurantMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry<Restaurant, Long>::getValue).reversed()).limit(5)
				.map(e -> e.getKey()).toList();

	}

	public List<Restaurant> topFiveHighestRatedRestaurants() {
		Map<Restaurant, Double> restaurantMap = Storage.getInstance().getReviews().stream()
				.collect(Collectors.groupingBy(e -> e.getRestaurant(), Collectors.averagingDouble(e -> e.getRating())));
		return restaurantMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry<Restaurant, Double>::getValue).reversed()).limit(5)
				.map(e -> e.getKey()).toList();

	}

	public List<User> mostActiveUsers() {
		Map<User, Long> userMap = Storage.getInstance().getReviews().stream()
				.collect(Collectors.groupingBy(e -> e.getUser(), Collectors.counting()));
		List<Entry<User, Long>> reviews = userMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry<User, Long>::getValue).reversed()).limit(3).toList();
		return reviews.stream().map(e -> e.getKey()).toList();
	}

}
