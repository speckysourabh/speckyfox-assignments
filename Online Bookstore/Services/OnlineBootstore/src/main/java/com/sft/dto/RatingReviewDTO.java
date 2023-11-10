package com.sft.dto;

import lombok.Data;

@Data
public class RatingReviewDTO {
	private Long bookId;
	private Integer rating;
	private String review;
}
