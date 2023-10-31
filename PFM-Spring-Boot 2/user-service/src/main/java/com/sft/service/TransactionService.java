package com.sft.service;

import java.util.List;

import com.sft.entity.external.TransactionEntity;

public interface TransactionService {

	TransactionEntity addTransaction(TransactionEntity transactionEntity);

	List<TransactionEntity> getAllTransaction(Long userId);

}
