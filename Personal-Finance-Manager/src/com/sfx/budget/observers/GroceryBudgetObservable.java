package com.sfx.budget.observers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sfx.enums.ExpenseCategoryEnum;
import com.sfx.pojo.Budget;
import com.sfx.pojo.User;
import com.sfx.transaction.ExpenseTransaction;
import com.sfx.transaction.Transaction;
import com.sfx.utils.MyPrinter;

public class GroceryBudgetObservable implements BudgetObservable {

	private static Map<String, User> userMap = new HashMap<String, User>();

	@Override
	public void subscribe(User user) {
		userMap.put(user.getName(), user);
	}

	@Override
	public void unsubscribe(User user) {
		userMap.remove(user.getName());
	}

	@Override
	public void notifyUser(String userName, ExpenseTransaction expenseTransaction) {
		User user = userMap.get(userName);
		Budget budget = user.getBudget(ExpenseCategoryEnum.GROCERY);
		List<Transaction> expenseTransactions = user.getExpenseTransactions();
		long trasactionAmount = expenseTransactions.stream()
				.collect(Collectors.summingLong(e -> e.getTransactionAmount()));

		if (trasactionAmount >= budget.getBudget()) {
			MyPrinter.getInstance().budgetExceededReminder(budget, expenseTransaction);
		}

	}

}
