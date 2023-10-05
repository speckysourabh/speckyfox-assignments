package com.sfx.db;

import com.sfx.pojo.Budget;

public interface BudgetStorage {
	Budget getBudget(String userName);
	void setBudget(String userName, Budget budget);
}
