package com.sft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.RatingReviewEntity;

public interface RatingReviewRepository extends JpaRepository<RatingReviewEntity, Long> {
    List<RatingReviewEntity> findByBookId(Long bookId);
}
