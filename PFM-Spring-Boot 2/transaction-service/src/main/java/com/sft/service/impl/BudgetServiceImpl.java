package com.sft.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sft.dto.BudgetCategoryDTO;
import com.sft.entity.external.BudgetEntity;
import com.sft.service.BudgetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BudgetServiceImpl implements BudgetService {

	RestTemplate restTemplate = new RestTemplate();

	@Value("${budget.service.url}")
	private String budgetServiceBaseUrl;

	@Override
	public BudgetEntity getBudgetByCategory(BudgetCategoryDTO budgetCategoryDTO, Long userId) {
		String path = budgetServiceBaseUrl + "/budgets/category/" + userId;
		log.info(path);
		return restTemplate.postForEntity(path, budgetCategoryDTO, BudgetEntity.class).getBody();
	}

	@Override
	public BudgetEntity addBudget(BudgetEntity budgetEntity) {
		String path = budgetServiceBaseUrl + "/budgets";
		log.info(path);
		return restTemplate.postForEntity(path, budgetEntity, BudgetEntity.class).getBody();
	}

}
