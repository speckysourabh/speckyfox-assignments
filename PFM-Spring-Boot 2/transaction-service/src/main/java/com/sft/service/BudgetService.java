package com.sft.service;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.external.BudgetEntity;

public interface BudgetService {

	BudgetEntity getBudgetByCategory(BudgetCategoryDTO budgetCategoryDTO, Long userId);

	BudgetEntity addBudget(BudgetEntity budgetEntity);

}
