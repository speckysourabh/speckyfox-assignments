package com.sft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.entity.BookEntity;
import com.sft.entity.RatingReviewEntity;
import com.sft.entity.UserEntity;
import com.sft.repository.BookRepository;
import com.sft.repository.RatingReviewRepository;
import com.sft.repository.UserRepository;
import com.sft.service.PurchaseService;
import com.sft.service.RatingReviewService;
import com.sft.service.security.JwtService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RatingReviewServiceImpl implements RatingReviewService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PurchaseService purchaseService;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    public void addRatingReview(String authHeader, Long bookId, int rating, String review) {
    	String userEmail = jwtService.getEmailByToken(authHeader);
        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userEmail));

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));

        // Ensure the user has purchased the book before allowing rating and review
        if (!purchaseService.isBookPurchased(user.getEmail(), book.getId())) {
            throw new RuntimeException("User has not purchased the book. Cannot add rating and review.");
        }

        RatingReviewEntity ratingReview = new RatingReviewEntity();
        ratingReview.setUser(user);
        ratingReview.setBook(book);
        ratingReview.setRating(rating);
        ratingReview.setReview(review);

        ratingReviewRepository.save(ratingReview);
    }

    public List<RatingReviewEntity> getBookRatingReviews(Long bookId) {
        return ratingReviewRepository.findByBookId(bookId);
    }
}

