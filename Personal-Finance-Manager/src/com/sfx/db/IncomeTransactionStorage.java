package com.sfx.db;

import java.util.ArrayList;
import java.util.List;

import com.sfx.transaction.Transaction;

public class IncomeTransactionStorage implements TransactionStorage {

	private static List<Transaction> transactions = new ArrayList<>();
	private static IncomeTransactionStorage storage;

	private IncomeTransactionStorage() {
	}

	public List<Transaction> getItems() {
		return transactions;
	}

	public void setItem(Transaction transaction) {
		transactions.add(transaction);
		int len = transactions.size();
	}

	public static TransactionStorage getInstance() {
		if (storage == null) {
			storage = new IncomeTransactionStorage();
		}
		return storage;
	}

}
