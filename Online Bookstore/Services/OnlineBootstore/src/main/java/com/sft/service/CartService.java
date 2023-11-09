package com.sft.service;

import java.util.Set;

import com.sft.dto.BookDTO;
import com.sft.dto.CartDTO;

public interface CartService {

	CartDTO saveToCart(CartDTO cartDTO, String authHeader);

	Set<BookDTO> fetchAllCartItems(String authHeader);

	Boolean deleteItem(String authHeader, Long bookId);

}
