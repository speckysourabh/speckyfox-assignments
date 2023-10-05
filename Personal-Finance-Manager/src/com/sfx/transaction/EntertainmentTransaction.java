package com.sfx.transaction;

import com.sfx.enums.ExpenseCategoryEnum;

public class EntertainmentTransaction implements ExpenseTransaction {
	
	private long amount;
	
	public EntertainmentTransaction(long amount) {
		super();
		this.amount = amount;
	}

	@Override
	public String getTrasactionCategory() {
		return ExpenseCategoryEnum.ENTERTAINMENT.toString();
	}

	@Override
	public long getTransactionAmount() {
		return this.amount;
	}

}
