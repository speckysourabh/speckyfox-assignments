package com.sfx.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.setProperty("MY_ENV_VARIABLE", "my_value");
	}
	
}
