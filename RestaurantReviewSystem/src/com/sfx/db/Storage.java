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

		restaurants.add(new Restaurant(1L, "Restaurant A", "City A", "Italian"));
		restaurants.add(new Restaurant(2L, "Restaurant B", "City B", "Mexican"));
		restaurants.add(new Restaurant(3L, "Restaurant C", "City C", "Japanese"));
		restaurants.add(new Restaurant(4L, "Restaurant D", "City D", "Indian"));
		restaurants.add(new Restaurant(5L, "Restaurant E", "City E", "Chinese"));
		restaurants.add(new Restaurant(6L, "Restaurant F", "City F", "French"));
		restaurants.add(new Restaurant(7L, "Restaurant G", "City G", "Greek"));
		restaurants.add(new Restaurant(8L, "Restaurant H", "City H", "Thai"));
		restaurants.add(new Restaurant(9L, "Restaurant I", "City I", "Mexican"));
		restaurants.add(new Restaurant(10L, "Restaurant J", "City J", "Italian"));

		users.add(new User(1L, "Alice", LocalDate.of(2020, 5, 15)));
		users.add(new User(2L, "Bob", LocalDate.of(2019, 9, 28)));
		users.add(new User(3L, "Charlie", LocalDate.of(2021, 3, 10)));
		users.add(new User(4L, "David", LocalDate.of(2018, 12, 5)));
		users.add(new User(5L, "Eve", LocalDate.of(2022, 7, 19)));

		reviews.add(new Review(1L, 1L, 10L, 4, "Great food!", LocalDate.now().minusDays(10)));
		reviews.add(new Review(2L, 2L, 2L, 5, "Excellent service!", LocalDate.now().minusDays(20)));
		reviews.add(new Review(3L, 3L, 3L, 3, "Average experience.", LocalDate.now().minusDays(30)));
		reviews.add(new Review(4L, 4L, 4L, 2, "Disappointing.", LocalDate.now().minusDays(40)));
		reviews.add(new Review(5L, 5L, 5L, 4, "Delicious dishes!", LocalDate.now().minusDays(50)));
		reviews.add(new Review(6L, 1L, 7L, 3, "Decent food.", LocalDate.now().minusDays(5)));
		reviews.add(new Review(7L, 2L, 3L, 4, "Friendly staff.", LocalDate.now().minusDays(15)));
		reviews.add(new Review(8L, 3L, 4L, 2, "Not recommended.", LocalDate.now().minusDays(25)));
		reviews.add(new Review(9L, 4L, 5L, 5, "Outstanding experience!", LocalDate.now().minusDays(35)));
		reviews.add(new Review(10L, 5L, 6L, 3, "Unique flavors.", LocalDate.now().minusDays(45)));
		reviews.add(new Review(11L, 1L, 7L, 4, "Great ambiance.", LocalDate.now().minusDays(55)));
		reviews.add(new Review(12L, 2L, 8L, 2, "Poor service.", LocalDate.now().minusDays(65)));
		reviews.add(new Review(13L, 3L, 9L, 5, "Delighted!", LocalDate.now().minusDays(75)));
		reviews.add(new Review(14L, 4L, 1L, 3, "Tasty cuisine.", LocalDate.now().minusDays(85)));
		reviews.add(new Review(15L, 5L, 7L, 4, "Awesome place!", LocalDate.now().minusDays(95)));
		reviews.add(new Review(16L, 1L, 4L, 2, "Needs improvement.", LocalDate.now().minusDays(105)));
		reviews.add(new Review(17L, 2L, 5L, 5, "Exquisite dishes.", LocalDate.now().minusDays(115)));
		reviews.add(new Review(18L, 3L, 10L, 4, "Cozy atmosphere.", LocalDate.now().minusDays(125)));
		reviews.add(new Review(19L, 4L, 2L, 3, "Good value.", LocalDate.now().minusDays(135)));
		reviews.add(new Review(20L, 5L, 3L, 4, "Impressed!", LocalDate.now().minusDays(145)));
		reviews.add(new Review(21L, 1L, 2L, 4, "Lovely evening.", LocalDate.now().minusDays(155)));
		reviews.add(new Review(22L, 2L, 8L, 5, "Fantastic food!", LocalDate.now().minusDays(165)));
		reviews.add(new Review(23L, 3L, 4L, 3, "Decent experience.", LocalDate.now().minusDays(175)));
		reviews.add(new Review(24L, 4L, 5L, 2, "Not satisfied.", LocalDate.now().minusDays(185)));
		reviews.add(new Review(25L, 5L, 6L, 4, "Recommended!", LocalDate.now().minusDays(195)));
		reviews.add(new Review(26L, 1L, 3L, 5, "Excellent ambiance.", LocalDate.now().minusDays(205)));
		reviews.add(new Review(27L, 2L, 8L, 3, "Good food.", LocalDate.now().minusDays(215)));
		reviews.add(new Review(28L, 3L, 5L, 4, "Delicious dishes!", LocalDate.now().minusDays(225)));
		reviews.add(new Review(29L, 4L, 1L, 2, "Needs improvement.", LocalDate.now().minusDays(235)));
		reviews.add(new Review(30L, 5L, 9L, 5, "Impressive!", LocalDate.now().minusDays(245)));

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
