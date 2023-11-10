package com.sft.service;

public interface PurchaseService {

	void purchaseBook(String authHeader, Long bookId);
	boolean isBookPurchased(String userEmail, Long bookId);

}
