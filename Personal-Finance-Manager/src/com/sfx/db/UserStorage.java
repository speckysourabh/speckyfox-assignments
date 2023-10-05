package com.sfx.db;

import java.util.ArrayList;
import java.util.List;

import com.sfx.pojo.User;

public class UserStorage {
	
	private static List<User> users= new ArrayList<User>();
	
	public boolean isUserExist(User user) {
		return users.stream().anyMatch(e -> e.getName().equals(user.getName()) && e.getPassword().equals(user.getPassword()));
	}
	
	public void saveUser(User user) {
		users.add(user);
	}

}
