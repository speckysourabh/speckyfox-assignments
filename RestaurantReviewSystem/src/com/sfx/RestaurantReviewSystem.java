package com.sfx;

import java.util.Scanner;

import com.sfx.db.Storage;
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
		analytics.topFiveMostReviewedRestaurants();
		
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
		}
	}
}
