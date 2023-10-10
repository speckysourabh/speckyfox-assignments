package com.sfx;

import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("Choose an option : ");
		System.out.println("1. Serialize order");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Do you want to exclude any of the below order field ?");
			System.out.println("1. Product amout");
			System.out.println("2. Product description");
			int choice2 = scanner.nextInt();
			serializeOrder(choice2);
		}
		}

	}

	public static List<String> serializeOrder(int choice) throws Exception {

		switch (choice) {
		case 1: {
			List<Order> orders = Storage.getInstance().getOrders();
			List<Order> list = orders.stream().map(e -> {
				e.setAmount(null);
				return e;
			}).toList();
			ObjectMapper mapper = new ObjectMapper();
			return list.stream().map(e -> {
				try {
					return mapper.writeValueAsString(e);
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}).toList();

		}
		case 2: {
			List<Order> orders = Storage.getInstance().getOrders();
			List<Order> list = orders.stream().map(e -> {
				e.setDescription(null);
				return e;
			}).toList();
			ObjectMapper mapper = new ObjectMapper();
			return list.stream().map(e -> {
				try {
					return mapper.writeValueAsString(e);
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}).toList();

		}
		default: {
			throw new Exception("Wrong choice");
		}
		}
	}
}
