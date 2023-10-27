package com.sft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.TransactionEntity;
import com.sft.entity.external.BudgetEntity;
import com.sft.enums.TransactionTypeEnum;
import com.sft.repository.TransactionRepository;
import com.sft.service.TransactionService;
import com.sft.service.external.BudgetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private BudgetService budgetService;

	@Override
	public List<TransactionEntity> getAllUserTransaction(Long userId) {
		return transactionRepository.findByUserId(userId);
	}

	@Override
	public TransactionEntity addTransacction(TransactionEntity transactionEntity) {
		BudgetCategoryDTO budgetCategoryDTO = new BudgetCategoryDTO();
		budgetCategoryDTO.setCategory(transactionEntity.getCategory());
		
		if(transactionEntity.getCategory().equals(TransactionTypeEnum.EXPENSE.toString())) {
			BudgetEntity budgetEntity;
			try {
				budgetEntity = budgetService.getBudgetByCategory(budgetCategoryDTO, transactionEntity.getUserId()).getBody();
				budgetEntity.setUsedAmount(budgetEntity.getUsedAmount()+transactionEntity.getAmount());
				budgetService.addBudget(budgetEntity);
			} catch (Exception e) {
				log.info("No budget found");
				e.printStackTrace();
			}
		}
		
		return transactionRepository.save(transactionEntity);
	}

}
