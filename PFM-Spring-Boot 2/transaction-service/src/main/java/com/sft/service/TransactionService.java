package com.sft.service;

import java.util.List;

import com.sft.dto.TransactionFilterDTO;
import com.sft.entity.TransactionEntity;

public interface TransactionService {

	List<TransactionEntity> getAllUserTransaction(Long userId);

	TransactionEntity addTransacction(TransactionEntity transactionEntity) throws Exception;

	List<TransactionEntity> getTransactionByFilter(TransactionFilterDTO transactionFilterDTO);

}
