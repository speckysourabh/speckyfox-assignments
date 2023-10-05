package com.sfx.transaction;

import com.sfx.enums.TransactionTypeEnum;

public interface ExpenseTransaction extends Transaction {
	default String getTransactionType() {
		return TransactionTypeEnum.EXPENSE.toString();
	}
}
