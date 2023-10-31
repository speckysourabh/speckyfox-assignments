package com.sft.dto;

import java.util.List;

import com.sft.entity.UserEntity;
import com.sft.entity.external.BudgetEntity;

import lombok.Data;

@Data
public class UserBudgetDTO {

	private UserEntity userEntity;
	private List<BudgetEntity> budgets;
	
}
