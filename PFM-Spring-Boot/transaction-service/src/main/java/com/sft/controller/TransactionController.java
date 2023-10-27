package com.sft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.entity.TransactionEntity;
import com.sft.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{userId}")
	public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long userId) {
		List<TransactionEntity> transactions = transactionService.getAllUserTransaction(userId);
		return ResponseEntity.status(HttpStatus.OK).body(transactions);
	}
	
	@PostMapping
	public ResponseEntity<TransactionEntity> addTransaction(@RequestBody TransactionEntity transactionEntity) throws Exception {
		TransactionEntity transaction = transactionService.addTransacction(transactionEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
	}
	
}
