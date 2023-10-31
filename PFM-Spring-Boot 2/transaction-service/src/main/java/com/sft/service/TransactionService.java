package com.sft.service;

import java.util.List;

import com.sft.entity.TransactionEntity;

public interface TransactionService {

	List<TransactionEntity> getAllUserTransaction(Long userId);

	TransactionEntity addTransacction(TransactionEntity transactionEntity) throws Exception;

}
