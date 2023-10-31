package com.sft.service;

import java.util.List;

import com.sft.entity.external.BudgetEntity;

public interface BudgetService {

	List<BudgetEntity> getAllBudget(Long userId);

	BudgetEntity addBudget(BudgetEntity budgetEntity);

}
