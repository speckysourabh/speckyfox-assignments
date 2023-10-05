package com.sfx.db;

import java.util.List;

import com.sfx.transaction.Transaction;

public interface TransactionStorage {

	List<Transaction> getItems();
	void setItem(Transaction transaction);
	
}
