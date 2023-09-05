package com.sfx;

import java.util.Scanner;

import com.sfx.operations.Analytics;
import com.sfx.operations.ReviewFiltering;

public class RestaurantReviewSystem {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to \"Restaurant Review Analytics System\"");
		System.out.println("Choose an option !");
		System.out.println("1. Review Filtering");
		System.out.println("2. Analytics");
		System.out.println("3. Search");
		System.out.println("4. Sorting");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			filterReviews();
			break;
		}
		case 2: {
			analytics();
			break;
		}
		}
	}

	public static void analytics() {

		Analytics analytics = new Analytics();

		System.out.println("Choose an option !");
		System.out.println("1. Calculate the average rating of a restaurant.");
		System.out.println("2. List top 5 most reviewed restaurants.");
		System.out.println("3. List top 5 highest-rated restaurants (average rating)");
		System.out.println("4. Find the most active users (users who have provided the most reviews).");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.print("Enter restaurant id: ");
			System.out.println("Average rating is : " + analytics.averageRatingOfRestaurant(scanner.nextLong()));
			break;
		}
		case 2: {
			System.out.print("Below are the top 5 most reviewed restaurants : ");
			analytics.topFiveMostReviewedRestaurants().stream().forEach(System.out::println);
			;
			break;
		}
		case 3: {
			System.out.print("Below are the top 5 highest rated restaurants : ");
			analytics.topFiveHighestRatedRestaurants().stream().forEach(System.out::println);
			;
			break;
		}
		case 4: {
			System.out.println("Below are the top 3 most active users : ");
			analytics.mostActiveUsers().stream().forEach(System.out::println);
			break;
		}
		default: {
			throw new RuntimeException("Wrong choice");
		}

		}

	}

	public static void filterReviews() {

		ReviewFiltering filtering = new ReviewFiltering();

		System.out.println("Choose an option !");
		System.out.println("1. Show all reviews of a particular user");
		System.out.println("2. Show all reviews of a Restaurant");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.print("Enter user id: ");
			filtering.getReviewsByUser(scanner.nextLong()).stream().forEach(System.out::println);
			break;
		}
		case 2: {
			System.out.print("Enter restaurant id: ");
			filtering.getReviewByRestaurant(scanner.nextLong()).forEach(System.out::println);
			break;
		}
		default: {
			throw new RuntimeException("Wrong choice");
		}

		}
	}
}
