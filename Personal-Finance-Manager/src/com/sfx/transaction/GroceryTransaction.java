package com.sfx.transaction;

import com.sfx.enums.ExpenseCategoryEnum;

public class GroceryTransaction implements ExpenseTransaction {
	private long amount;

	public GroceryTransaction(long amount) {
		super();
		this.amount = amount;
	}

	@Override
	public String getTrasactionCategory() {
		return ExpenseCategoryEnum.GROCERY.toString();
	}

	@Override
	public long getTransactionAmount() {
		return this.amount;
	}
}
