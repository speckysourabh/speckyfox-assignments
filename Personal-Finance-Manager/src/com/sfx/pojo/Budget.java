package com.sfx.pojo;

import com.sfx.enums.ExpenseCategoryEnum;

public class Budget {
	private long amount;
	private ExpenseCategoryEnum budgetCategory;
	
	public Budget(long amount, ExpenseCategoryEnum budgetCategory) {
		super();
		this.amount = amount;
		this.budgetCategory = budgetCategory;
	}

	public long getBudget() {
		return this.amount;
	}

	public ExpenseCategoryEnum getBudgetCategory() {
		return this.budgetCategory;
	}
}
