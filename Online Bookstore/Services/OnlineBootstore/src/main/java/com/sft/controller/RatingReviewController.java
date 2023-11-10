package com.sft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.dto.RatingReviewDTO;
import com.sft.entity.RatingReviewEntity;
import com.sft.service.RatingReviewService;

@RestController
@RequestMapping("${project.version}/ratings-reviews")
@CrossOrigin("http://localhost:3000/")
public class RatingReviewController {

    @Autowired
    private RatingReviewService ratingReviewService;

    @PostMapping("/add")
    public ResponseEntity<String> addRatingReview(
    		@RequestHeader("Authorization") String authHeader,
			@RequestBody RatingReviewDTO ratingReviewDTO) {
        ratingReviewService.addRatingReview(authHeader, ratingReviewDTO.getBookId(), ratingReviewDTO.getRating(), ratingReviewDTO.getReview());
        return ResponseEntity.ok("Rating and review added successfully");
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<RatingReviewEntity>> getBookRatingReviews(@PathVariable Long bookId) {
        List<RatingReviewEntity> ratingReviews = ratingReviewService.getBookRatingReviews(bookId);
        return ResponseEntity.ok(ratingReviews);
    }
}

