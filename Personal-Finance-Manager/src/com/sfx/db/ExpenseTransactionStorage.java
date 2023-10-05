package com.sfx.db;

import java.util.ArrayList;
import java.util.List;

import com.sfx.transaction.Transaction;

public class ExpenseTransactionStorage implements TransactionStorage {

	private static List<Transaction> transactions = new ArrayList<>();
	private static TransactionStorage storage;

	private ExpenseTransactionStorage() {
	}

	public List<Transaction> getItems() {
		return transactions;
	}

	public void setItem(Transaction transaction) {
		transactions.add(transaction);
	}

	public static TransactionStorage getInstance() {
		if (storage == null) {
			storage = new ExpenseTransactionStorage();
		}
		return storage;
	}

}
