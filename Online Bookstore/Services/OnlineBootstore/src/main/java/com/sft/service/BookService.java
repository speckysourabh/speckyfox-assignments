package com.sft.service;

import java.util.List;

import com.sft.dto.BookDTO;
import com.sft.exception.ResourceNotFoundException;

public interface BookService {

	BookDTO addBook(BookDTO bookDTO);

	List<BookDTO> getAllBooks();

	BookDTO getBookById(Long bookId) throws ResourceNotFoundException;

	void deleteBookById(Long bookId) throws ResourceNotFoundException;

	void updateBookById(BookDTO bookDTO) throws ResourceNotFoundException;

}
