package com.sfx.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sfx.pojo.Restaurant;
import com.sfx.pojo.Review;
import com.sfx.pojo.User;

public class Storage {

	private static Storage storage;

	private List<User> users = new ArrayList<>();
	private List<Review> reviews = new ArrayList<>();
	private List<Restaurant> restaurants = new ArrayList<>();

	private Storage() {

		Restaurant restaurant1 = new Restaurant(1L, "Restaurant A", "City A", "Italian");
		Restaurant restaurant2 = new Restaurant(2L, "Restaurant B", "City B", "Mexican");
		Restaurant restaurant3 = new Restaurant(3L, "Restaurant C", "City C", "Japanese");
		Restaurant restaurant4 = new Restaurant(4L, "Restaurant D", "City D", "Indian");
		Restaurant restaurant5 = new Restaurant(5L, "Restaurant E", "City E", "Chinese");
		Restaurant restaurant6 = new Restaurant(6L, "Restaurant F", "City F", "French");
		Restaurant restaurant7 = new Restaurant(7L, "Restaurant G", "City G", "Greek");
		Restaurant restaurant8 = new Restaurant(8L, "Restaurant H", "City H", "Thai");
		Restaurant restaurant9 = new Restaurant(9L, "Restaurant I", "City I", "Mexican");
		Restaurant restaurant10 = new Restaurant(10L, "Restaurant J", "City J", "Italian");

		restaurants.add(restaurant1);
		restaurants.add(restaurant2);
		restaurants.add(restaurant3);
		restaurants.add(restaurant4);
		restaurants.add(restaurant5);
		restaurants.add(restaurant6);
		restaurants.add(restaurant7);
		restaurants.add(restaurant8);
		restaurants.add(restaurant9);
		restaurants.add(restaurant10);

		User user1 = new User(1L, "Alice", LocalDate.of(2020, 5, 15));
		User user2 = new User(2L, "Bob", LocalDate.of(2019, 9, 28));
		User user3 = new User(3L, "Charlie", LocalDate.of(2021, 3, 10));
		User user4 = new User(4L, "David", LocalDate.of(2018, 12, 5));
		User user5 = new User(5L, "Eve", LocalDate.of(2022, 7, 19));

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		reviews.add(new Review(1L, user4, restaurant10, 4, "Great food!", LocalDate.now().minusDays(10)));
		reviews.add(new Review(2L, user2, restaurant2, 5, "Excellent service!", LocalDate.now().minusDays(20)));
		reviews.add(new Review(3L, user3, restaurant3, 3, "Average experience.", LocalDate.now().minusDays(30)));
		reviews.add(new Review(4L, user4, restaurant4, 2, "Disappointing.", LocalDate.now().minusDays(40)));
		reviews.add(new Review(5L, user5, restaurant5, 4, "Delicious dishes!", LocalDate.now().minusDays(50)));
		reviews.add(new Review(6L, user1, restaurant7, 3, "Decent food.", LocalDate.now().minusDays(5)));
		reviews.add(new Review(7L, user2, restaurant3, 4, "Friendly staff.", LocalDate.now().minusDays(15)));
		reviews.add(new Review(8L, user5, restaurant4, 2, "Not recommended.", LocalDate.now().minusDays(25)));
		reviews.add(new Review(9L, user4, restaurant5, 5, "Outstanding experience!", LocalDate.now().minusDays(35)));
		reviews.add(new Review(10L, user5, restaurant6, 3, "Unique flavors.", LocalDate.now().minusDays(45)));
		reviews.add(new Review(11L, user1, restaurant7, 4, "Great ambiance.", LocalDate.now().minusDays(55)));
		reviews.add(new Review(12L, user2, restaurant8, 2, "Poor service.", LocalDate.now().minusDays(65)));
		reviews.add(new Review(13L, user3, restaurant9, 5, "Delighted!", LocalDate.now().minusDays(75)));
		reviews.add(new Review(14L, user4, restaurant1, 3, "Tasty cuisine.", LocalDate.now().minusDays(85)));
		reviews.add(new Review(15L, user5, restaurant7, 4, "Awesome place!", LocalDate.now().minusDays(95)));
		reviews.add(new Review(16L, user5, restaurant4, 2, "Needs improvement.", LocalDate.now().minusDays(105)));
		reviews.add(new Review(17L, user2, restaurant5, 5, "Exquisite dishes.", LocalDate.now().minusDays(115)));
		reviews.add(new Review(18L, user3, restaurant10, 4, "Cozy atmosphere.", LocalDate.now().minusDays(125)));
		reviews.add(new Review(19L, user4, restaurant2, 3, "Good value.", LocalDate.now().minusDays(135)));
		reviews.add(new Review(20L, user5, restaurant3, 4, "Impressed!", LocalDate.now().minusDays(145)));
		reviews.add(new Review(21L, user1, restaurant2, 4, "Lovely evening.", LocalDate.now().minusDays(155)));
		reviews.add(new Review(22L, user2, restaurant8, 5, "Fantastic food!", LocalDate.now().minusDays(165)));
		reviews.add(new Review(23L, user3, restaurant4, 3, "Decent experience.", LocalDate.now().minusDays(175)));
		reviews.add(new Review(24L, user4, restaurant5, 2, "Not satisfied.", LocalDate.now().minusDays(185)));
		reviews.add(new Review(25L, user5, restaurant6, 4, "Recommended!", LocalDate.now().minusDays(195)));
		reviews.add(new Review(26L, user1, restaurant3, 5,  "Excellent ambiance.", LocalDate.now().minusDays(205)));
		reviews.add(new Review(27L, user2, restaurant8, 3, "Good food.", LocalDate.now().minusDays(215)));
		reviews.add(new Review(28L, user3, restaurant5, 4, "Delicious dishes!", LocalDate.now().minusDays(225)));
		reviews.add(new Review(29L, user4, restaurant1, 2, "Needs improvement.", LocalDate.now().minusDays(235)));
		reviews.add(new Review(30L, user5, restaurant9, 5, "Impressive!", LocalDate.now().minusDays(255)));

	}

	public List<User> getUsers() {
		return users;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public static Storage getInstance() {
		if (storage == null) {
			storage = new Storage();
		}
		return storage;
	}

}
