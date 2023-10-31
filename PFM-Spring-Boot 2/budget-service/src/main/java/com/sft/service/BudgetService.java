package com.sft.service;

import java.util.List;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.BudgetEntity;

public interface BudgetService {

	List<BudgetEntity> getAllBudget(Long userId);

	BudgetEntity addBudget(BudgetEntity budgetEntity) throws Exception;

	public BudgetEntity getBudgetByCategory(BudgetCategoryDTO category, Long userId) throws Exception;

}
