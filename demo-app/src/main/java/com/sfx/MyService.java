package com.sfx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MyService {
	
	@Value("${my.property}")
	private String appTitle;

	@PostConstruct
	public void startApplication() {
		System.out.printf("-- running application: %s --%n", appTitle);
	}

}
