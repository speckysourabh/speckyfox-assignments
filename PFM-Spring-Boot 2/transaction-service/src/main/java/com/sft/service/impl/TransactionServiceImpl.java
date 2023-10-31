package com.sft.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.dto.TransactionFilterDTO;
import com.sft.entity.TransactionEntity;
import com.sft.entity.external.BudgetEntity;
import com.sft.enums.FilterTypeEnum;
import com.sft.enums.TransactionTypeEnum;
import com.sft.repository.TransactionRepository;
import com.sft.service.BudgetService;
import com.sft.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BudgetService budgetService;

	@CacheEvict(cacheNames = "myCache", key = "#userId")
	@Override
	public List<TransactionEntity> getAllUserTransaction(Long userId) {
		return transactionRepository.findByUserId(userId);
	}

	@Override
	public TransactionEntity addTransacction(TransactionEntity transactionEntity) {
		BudgetCategoryDTO budgetCategoryDTO = new BudgetCategoryDTO();
		budgetCategoryDTO.setCategory(transactionEntity.getCategory());

		if (transactionEntity.getType().equals(TransactionTypeEnum.EXPENSE.toString())) {
			BudgetEntity budgetEntity;
			try {
				budgetEntity = budgetService.getBudgetByCategory(budgetCategoryDTO, transactionEntity.getUserId());
				budgetEntity.setUsedAmount(budgetEntity.getUsedAmount() + transactionEntity.getAmount());
				budgetService.addBudget(budgetEntity);
			} catch (Exception e) {
				log.info("No budget found");
				e.printStackTrace();
			}
		}

		return transactionRepository.save(transactionEntity);
	}

	@Override
	public List<TransactionEntity> getTransactionByFilter(TransactionFilterDTO transactionFilterDTO) {

		Long userId = transactionFilterDTO.getUserId();

		if (transactionFilterDTO.getFilterType().equals(FilterTypeEnum.WEEKLY.toString())) {
			return transactionRepository.findTransactionByFilterType(LocalDate.now().minusWeeks(1), userId);
		} else if (transactionFilterDTO.getFilterType().equals(FilterTypeEnum.MONTHLY.toString())) {
			return transactionRepository.findTransactionByFilterType(LocalDate.now().minusMonths(1), userId);
		} else if (transactionFilterDTO.getFilterType().equals(FilterTypeEnum.YEARLY.toString())) {
			return transactionRepository.findTransactionByFilterType(LocalDate.now().minusYears(1), userId);
		} else {
			return this.getAllUserTransaction(userId);
		}
	}

}
