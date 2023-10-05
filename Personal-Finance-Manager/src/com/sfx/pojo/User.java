package com.sfx.pojo;

import java.util.List;
import java.util.stream.Collectors;

import com.sfx.budget.observers.BudgetObservable;
import com.sfx.budget.observers.BudgetObserver;
import com.sfx.budget.observers.SimpleBudgetObserver;
import com.sfx.db.BudgetStorage;
import com.sfx.db.ExpenseTransactionStorage;
import com.sfx.db.GoalStorage;
import com.sfx.db.IncomeTransactionStorage;
import com.sfx.enums.ExpenseCategoryEnum;
import com.sfx.factory.BudgetObservableFactory;
import com.sfx.factory.BudgetStorageFactory;
import com.sfx.transaction.ExpenseTransaction;
import com.sfx.transaction.IncomeTransaction;
import com.sfx.transaction.Transaction;

public class User {
	private String name;
	private String password;
	private BudgetObserver budgetObserver;

	public User(String name, String passowrd) {
		this.name = name;
		this.password = passowrd;
	}

	public long getIncome() {
		return IncomeTransactionStorage.getInstance().getItems().stream()
				.collect(Collectors.summingLong(e -> e.getTransactionAmount())).longValue();
	}

	public String getName() {
		return name;
	}

	public List<Transaction> getIncomeTransactions() {
		return IncomeTransactionStorage.getInstance().getItems();
	}
	
	
	public void setIncomeTransaction(IncomeTransaction incomeTransaction) {
		IncomeTransactionStorage.getInstance().setItem(incomeTransaction);
	}

	public List<Transaction> getExpenseTransactions() {
		return ExpenseTransactionStorage.getInstance().getItems();
	}
	
	public void setExpenseTransaction(ExpenseTransaction expenseTransaction) {
		ExpenseTransactionStorage.getInstance().setItem(expenseTransaction);
		List<Transaction> items = ExpenseTransactionStorage.getInstance().getItems();
		if(budgetObserver!=null)
			budgetObserver.update(name, expenseTransaction);
	}

	public Budget getBudget(ExpenseCategoryEnum budgetCategory) {
		BudgetStorage storage = BudgetStorageFactory.findBudgetStorage(budgetCategory);
		return storage.getBudget(name);
	}

	public void setBudget(Budget budget) {
		BudgetObservable budgetObservable = BudgetObservableFactory.findBudgetObservable(budget.getBudgetCategory());
		budgetObservable.subscribe(this);
		budgetObserver = new SimpleBudgetObserver(budgetObservable);
		BudgetStorageFactory.findBudgetStorage(budget.getBudgetCategory()).setBudget(this.name, budget);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setGoal(Goal goal) {
		GoalStorage goalStorage = GoalStorage.getInstance();
		goalStorage.setUserGoal(name, goal);
	}
	
	public List<Goal> getGoal() {
		return GoalStorage.getInstance().getGoalByUsername(name);
	}

}
