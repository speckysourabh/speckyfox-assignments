package com.sft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sft.entity.external.TransactionEntity;
import com.sft.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	RestTemplate restTemplate = new RestTemplate();

	@Value("${transaction.service.url}")
	private String budgetServiceBaseUrl;

	@Override
	public TransactionEntity addTransaction(TransactionEntity transactionEntity) {
		String path = budgetServiceBaseUrl + "/transactions";
		log.info(path);
		return restTemplate.postForEntity(path, transactionEntity, TransactionEntity.class).getBody();
	}

	@Override
	public List<TransactionEntity> getAllTransaction(Long userId) {
		String path = budgetServiceBaseUrl + "/transactions/"+userId;
		log.info(path);
		return restTemplate.getForEntity(path, List.class).getBody();
	}

}
