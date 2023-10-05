package com.sfx.budget.observers;

import com.sfx.pojo.User;
import com.sfx.transaction.ExpenseTransaction;

public interface BudgetObservable {
	void subscribe(User user);
	void unsubscribe(User user);
	void notifyUser(String userName, ExpenseTransaction expenseTransaction);
}
