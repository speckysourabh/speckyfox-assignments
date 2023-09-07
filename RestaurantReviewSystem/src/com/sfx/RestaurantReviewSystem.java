package com.sfx;

import java.time.Month;
import java.util.Scanner;

import com.sfx.operations.Analytics;
import com.sfx.operations.ReviewFiltering;
import com.sfx.operations.Search;
import com.sfx.operations.Sorting;

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
		case 3: {
			search();
			break;
		}
		case 4: {
			sort();
			break;
		}
		default: {

		}
		}
	}

	private static void sort() {
		Sorting sorting = new Sorting();
		System.out.println("Choose an option !");
		System.out.println("1. Display reviews ( older to newer )");
		System.out.println("2. Display reviews ( newer to older )");
		System.out.println("3. Display restaurants in order of average rating.");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			sorting.sortReviewByDateAsc().stream().forEach(System.out::println);
			break;
		}
		case 2: {
			sorting.sortReviewByDateDesc().stream().forEach(System.out::println);
			break;
		}
		case 3: {
			sorting.displayRestaurantByAverageRating().entrySet().stream().forEach(System.out::println);;
			break;
		}
		default: {
			throw new RuntimeException("Wrong choice");
		}

		}

	}

	private static void search() {
		Search search = new Search();
		System.out.println("Choose an option !");
		System.out.println("1. Find all restaurants that match a given name or part of a name.");
		System.out.println("2. Find all reviews made in a particular month.");
		System.out.println("3. Find all reviews made in a particular year.");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Type something to search restaurant !");
			scanner.nextLine();
			String keyword = scanner.nextLine();
			search.findRestaurantsByKeyword(keyword).stream().forEach(System.out::println);
			break;
		}
		case 2: {
			System.out.println("Enter month number between 1-12");
			Month desiredMonth = getMonthByNumber(scanner.nextInt());
			search.findReviewsOfMonth(desiredMonth).stream().forEach(System.out::println);
			break;
		}
		case 3: {
			System.out.println("Enter year");
			int desiredYear = scanner.nextInt();
			search.findReviewsOfYear(desiredYear).stream().forEach(System.out::println);
			break;
		}
		default: {
			throw new RuntimeException("Wrong choice");
		}

		}

	}

	public static Month getMonthByNumber(int num) {
		return switch (num) {
		case 1 -> Month.JANUARY;
		case 2 -> Month.FEBRUARY;
		case 3 -> Month.MARCH;
		case 4 -> Month.APRIL;
		case 5 -> Month.MAY;
		case 6 -> Month.JUNE;
		case 7 -> Month.JULY;
		case 8 -> Month.AUGUST;
		case 9 -> Month.SEPTEMBER;
		case 10 -> Month.OCTOBER;
		case 11 -> Month.NOVEMBER;
		case 12 -> Month.DECEMBER;
		default -> throw new IllegalArgumentException("Invalid month number: " + num);
		};
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
			System.out.println("Enter restaurant id: ");
			System.out.println("Average rating is : " + analytics.averageRatingOfRestaurant(scanner.nextLong()));
			break;
		}
		case 2: {
			System.out.println("Below are the top 5 most reviewed restaurants : ");
			analytics.topFiveMostReviewedRestaurants().stream().forEach(System.out::println);
			;
			break;
		}
		case 3: {
			System.out.println("Below are the top 5 highest rated restaurants : ");
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
