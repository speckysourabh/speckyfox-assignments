package com.sft.service;

import java.util.List;

import com.sft.entity.RatingReviewEntity;

public interface RatingReviewService {

	void addRatingReview(String authHeader, Long bookId, int rating, String review);

	List<RatingReviewEntity> getBookRatingReviews(Long bookId);

}
