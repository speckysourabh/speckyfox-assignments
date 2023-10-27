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

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.BudgetEntity;
import com.sft.service.BudgetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/budgets")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;

	@GetMapping("/{userId}")
	public ResponseEntity<List<BudgetEntity>> getAllBudget(@PathVariable Long userId) {
		List<BudgetEntity> budgets = budgetService.getAllBudget(userId);
		return ResponseEntity.status(HttpStatus.OK).body(budgets);
	}
	
	@PostMapping("/category/{userId}")
	public ResponseEntity<BudgetEntity> getBudgetByCategory(@RequestBody BudgetCategoryDTO category, @PathVariable Long userId) throws Exception {
		log.info("Category - {} and User id - {}", category.getCategory(), userId);
		BudgetEntity budget = budgetService.getBudgetByCategory(category, userId);
		log.info("Result - {}", budget.getTargetAmount());
		return ResponseEntity.status(HttpStatus.OK).body(budget);
	}
	
	@PostMapping
	public ResponseEntity<BudgetEntity> addBudget(@RequestBody BudgetEntity BudgetEntity) throws Exception {
		BudgetEntity budget = budgetService.addBudget(BudgetEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(budget);
	}
	
}
