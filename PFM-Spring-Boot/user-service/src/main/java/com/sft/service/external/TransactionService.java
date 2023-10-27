package com.sft.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sft.entity.external.TransactionEntity;

@FeignClient(name = "transaction-service")
public interface TransactionService {
	@GetMapping("/transactions/{userId}")
	public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long userId);
	
	@PostMapping
	public ResponseEntity<TransactionEntity> addTransaction(@RequestBody TransactionEntity transactionEntity);
	
	@GetMapping("/transactions/test")
	public String testing();
}
