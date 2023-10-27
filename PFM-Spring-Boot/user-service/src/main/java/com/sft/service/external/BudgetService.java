package com.sft.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sft.entity.external.BudgetEntity;

@FeignClient(name = "budget-service")
public interface BudgetService {
	@GetMapping("/budgets/{userId}")
	public ResponseEntity<List<BudgetEntity>> getAllBudget(@PathVariable Long userId);
	
	@PostMapping("/budgets")
	public ResponseEntity<BudgetEntity> addBudget(@RequestBody BudgetEntity BudgetEntity);
}
