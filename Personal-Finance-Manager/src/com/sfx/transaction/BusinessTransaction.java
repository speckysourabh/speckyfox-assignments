package com.sfx.transaction;

import com.sfx.enums.IncomeCategoryEnum;

public class BusinessTransaction implements IncomeTransaction {
	
	private long amount;

	public BusinessTransaction(long amount) {
		super();
		this.amount = amount;
	}

	@Override
	public String getTrasactionCategory() {
		return IncomeCategoryEnum.BUSINESS.toString();
	}

	@Override
	public long getTransactionAmount() {
		return this.amount;
	}

}
