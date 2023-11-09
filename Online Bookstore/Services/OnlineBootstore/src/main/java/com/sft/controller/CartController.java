package com.sft.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.dto.BookDTO;
import com.sft.dto.CartDTO;
import com.sft.service.CartService;

@RestController
@RequestMapping("${project.version}/carts")
@CrossOrigin("http://localhost:3000/")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@PostMapping
	public ResponseEntity<CartDTO> addToCart(@RequestBody CartDTO cartDTO, @RequestHeader("Authorization") String authHeader) {
		CartDTO response = cartService.saveToCart(cartDTO, authHeader);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/getItems")
	public ResponseEntity<Set<BookDTO>> fetchItems(@RequestHeader("Authorization") String authHeader) {
		Set<BookDTO> response = cartService.fetchAllCartItems(authHeader);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Boolean> deleteCartItems(@RequestHeader("Authorization") String authHeader, @PathVariable Long bookId) {
		Boolean response = cartService.deleteItem(authHeader, bookId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
}
