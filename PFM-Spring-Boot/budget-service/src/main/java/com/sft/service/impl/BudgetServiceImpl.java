package com.sft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.BudgetEntity;
import com.sft.repository.BudgetRepository;
import com.sft.service.BudgetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BudgetServiceImpl implements BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public List<BudgetEntity> getAllBudget(Long userId) {
		return budgetRepository.findByUserId(userId);
	}

	@Override
	public BudgetEntity addBudget(BudgetEntity budgetEntity) throws Exception {
		log.info("Used amount - {}",budgetEntity.getUsedAmount());
		BudgetEntity budget = budgetRepository.findByUserIdAndCategory(budgetEntity.getUserId(), budgetEntity.getCategory());
		if(budget != null) {
			budget.setCategory(budgetEntity.getCategory());
			budget.setTargetAmount(budgetEntity.getTargetAmount());
			budget.setUsedAmount(budgetEntity.getUsedAmount());
			budget.setUserId(budgetEntity.getUserId());
			budgetEntity = budgetRepository.save(budget);
		} else {
			budgetRepository.save(budgetEntity);
		}
		return budgetEntity;
	}

	@Override
	public BudgetEntity getBudgetByCategory(BudgetCategoryDTO category, Long userId) throws Exception {
		log.info("User id - {}", userId);
		log.info("Category - {}", category.getCategory());
		BudgetEntity budget = budgetRepository.findByUserIdAndCategory(userId, category.getCategory());
		if(budget == null) {
			throw new Exception("No budget available");
		}
		return budget;
	}

}
