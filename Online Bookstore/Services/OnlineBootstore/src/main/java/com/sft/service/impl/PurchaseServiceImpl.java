package com.sft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.entity.BookEntity;
import com.sft.entity.PurchaseEntity;
import com.sft.entity.UserEntity;
import com.sft.repository.BookRepository;
import com.sft.repository.PurchaseRepository;
import com.sft.repository.UserRepository;
import com.sft.service.PurchaseService;
import com.sft.service.security.JwtService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;
    
    @Autowired
    private JwtService jwtService;

    public void purchaseBook(String authHeader, Long bookId) {
    	String email = jwtService.getEmailByToken(authHeader);
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + email));

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));

        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setUser(user);
        purchase.setBook(book);

        purchaseRepository.save(purchase);
    }
    
    public boolean isBookPurchased(String userEmail, Long bookId) {
    	 return purchaseRepository.findByUserEmailAndBookId(userEmail, bookId).isPresent();
    }
}

