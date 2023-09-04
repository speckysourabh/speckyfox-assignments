package com.sfx.operations;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sfx.db.Storage;

public class Analytics {

	public double averageRatingOfRestaurant(Long restaurantId) {
		return Storage.getInstance().getReviews().stream().filter(e -> e.getRestaurantId() == restaurantId)
				.collect(Collectors.averagingDouble(e -> e.getRating()));
	}
	
	public List<Long> topFiveMostReviewedRestaurants() {
		Map<Long, Long> restaurantMap = Storage.getInstance().getReviews().stream().collect(Collectors.groupingBy(e -> e.getRestaurantId(), Collectors.counting()));
		return restaurantMap.entrySet().stream().sorted(Comparator.comparing(e -> ((Map.Entry<Long, Long>)e).getValue())).limit(5).map(e->e.getKey()).toList();
	}

}
