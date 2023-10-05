package com.sfx.budget.observers;

import com.sfx.transaction.ExpenseTransaction;

public interface BudgetObserver {
	void update(String user, ExpenseTransaction expenseTransaction);
}
