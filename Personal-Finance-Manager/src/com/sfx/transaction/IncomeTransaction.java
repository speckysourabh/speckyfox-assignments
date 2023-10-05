package com.sfx.transaction;

import com.sfx.enums.TransactionTypeEnum;

public interface IncomeTransaction extends Transaction {
	default String getTransactionType() {
		return TransactionTypeEnum.INCOME.toString();
	}
}
