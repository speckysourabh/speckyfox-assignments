package com.sft.dto;

import lombok.Data;

@Data
public class TransactionFilterDTO {
	private Long userId;
	private String filterType;
}
