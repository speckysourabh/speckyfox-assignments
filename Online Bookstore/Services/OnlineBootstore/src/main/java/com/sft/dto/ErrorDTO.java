package com.sft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
	private String message;
	private String timestamp;
	private String exceptionName;
}
