package com.sfx.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfx.pojo.Goal;

public class GoalStorage {
	private Map<String, Goal> goals = new HashMap<String, Goal>();
	private static GoalStorage goalStorage;
	private GoalStorage() {}
	public void setUserGoal(String username, Goal goal) {
		goals.put(username, goal);
	}
	public List<Goal> getGoalByUsername(String username) {
		return goals.entrySet().stream().filter(e -> e.getKey().equals(username)).map(e -> e.getValue()).toList();
	}
	public static GoalStorage getInstance() {
		if(goalStorage==null) {
			goalStorage = new GoalStorage();
		}
		return goalStorage;
	}
}
