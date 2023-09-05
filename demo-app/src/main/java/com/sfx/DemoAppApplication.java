package com.sfx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		System.setProperty("app.title", "My Spring Application with system properties --");
		SpringApplication.run(DemoAppApplication.class, args);
	}

}
