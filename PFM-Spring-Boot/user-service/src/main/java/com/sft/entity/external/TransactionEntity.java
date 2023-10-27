package com.sft.entity.external;

import lombok.Data;

@Data
public class TransactionEntity {
	private Long id;
	private String type;
	private String category;
	private String amount;
	private Long userId;
}
