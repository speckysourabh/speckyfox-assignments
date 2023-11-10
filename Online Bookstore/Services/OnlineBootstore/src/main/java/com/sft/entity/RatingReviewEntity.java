package com.sft.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings_reviews")
public class RatingReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "book_id", nullable = false)
	private BookEntity book;

	private int rating;
	private String review;
	private LocalDateTime createdAt = LocalDateTime.now();
}
