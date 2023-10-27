package com.sft.entity.external;

import lombok.Data;

@Data
public class BudgetEntity {
	private Long id;
	private String category;
	private double targetAmount;
	private double usedAmount;
	private Long userId;
}
