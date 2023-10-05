package com.sfx.transaction;

import com.sfx.enums.IncomeCategoryEnum;

public class SalaryTransaction implements IncomeTransaction {
	
	private long amount;

	public SalaryTransaction(long amount) {
		super();
		this.amount = amount;
	}

	@Override
	public String getTrasactionCategory() {
		return IncomeCategoryEnum.SALARY.toString();
	}

	@Override
	public long getTransactionAmount() {
		return this.amount;
	}

}
