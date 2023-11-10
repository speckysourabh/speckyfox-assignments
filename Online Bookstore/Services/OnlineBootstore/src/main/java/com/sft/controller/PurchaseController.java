package com.sft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.service.PurchaseService;

@RestController
@RequestMapping("${project.version}/purchases")
@CrossOrigin("http://localhost:3000/")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase/{bookId}")
    public ResponseEntity<String> purchaseBook(@RequestHeader("Authorization") String authHeader, @PathVariable Long bookId) {
    	purchaseService.purchaseBook(authHeader, bookId);
        return ResponseEntity.ok("Book purchased successfully");
    }
}

