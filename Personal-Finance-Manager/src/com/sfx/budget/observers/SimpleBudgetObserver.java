package com.sfx.budget.observers;

import com.sfx.transaction.ExpenseTransaction;

public class SimpleBudgetObserver implements BudgetObserver{
	
	private BudgetObservable budgetObserverable;

	public SimpleBudgetObserver(BudgetObservable budgetObserverable) {
		super();
		this.budgetObserverable = budgetObserverable;
	}

	@Override
	public void update(String user, ExpenseTransaction expenseTransaction) {
		budgetObserverable.notifyUser(user, expenseTransaction);
	}

}
