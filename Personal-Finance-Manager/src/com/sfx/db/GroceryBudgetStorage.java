package com.sfx.db;

import java.util.HashMap;
import java.util.Map;

import com.sfx.pojo.Budget;

public class GroceryBudgetStorage implements BudgetStorage {

	private static Map<String, Budget> budgets = new HashMap<String, Budget>();

	@Override
	public Budget getBudget(String userName) {
		return budgets.get(userName);
	}

	@Override
	public void setBudget(String userName, Budget budget) {
		budgets.put(userName, budget);
	}
	
}
