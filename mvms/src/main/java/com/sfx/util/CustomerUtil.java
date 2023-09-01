package com.sfx.util;

import java.util.List;

public interface CustomerUtil {
	
	List<String> customerList = List.of("sourabh@gmail.com");
	
	static boolean isCustomerVIP(String email) {
		return customerList.contains(email);
	}
	
}
