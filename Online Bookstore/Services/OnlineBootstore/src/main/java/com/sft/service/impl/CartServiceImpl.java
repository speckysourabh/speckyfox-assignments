package com.sft.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.dto.BookDTO;
import com.sft.dto.CartDTO;
import com.sft.entity.CartEntity;
import com.sft.repository.BookRepository;
import com.sft.repository.CartRepository;
import com.sft.service.CartService;
import com.sft.service.security.JwtService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private JwtService jwtService;


	@Override
	public CartDTO saveToCart(CartDTO cartDTO, String authHeader) {

		CartEntity cartEntity = modelMapper.map(cartDTO, CartEntity.class);
		cartEntity.setUserEmail(jwtService.getEmailByToken(authHeader));

		return modelMapper.map(cartRepository.save(cartEntity), CartDTO.class);
	}


	@Override
	public Set<BookDTO> fetchAllCartItems(String authHeader) {
		
		String userName = jwtService.getEmailByToken(authHeader);
		
		Set<BookDTO> books = new HashSet<BookDTO>();
		
		List<CartEntity> findByUserEmail = cartRepository.findByUserEmail(userName);
		List<Long> list = findByUserEmail.stream().map(item -> item.getBookId()).distinct().toList();
		System.out.println(list);
		for(int i =0; i< list.size() ; i++) {
			books.add(modelMapper.map(bookRepository.findById(list.get(i)), BookDTO.class));
		}
		
		return books;
	}


	@Override
	public Boolean deleteItem(String authHeader, Long bookId) {
		String userName = jwtService.getEmailByToken(authHeader);
		cartRepository.deleteByUserEmailAndBookId(userName, bookId);
		return true;
	}
	
	

}
