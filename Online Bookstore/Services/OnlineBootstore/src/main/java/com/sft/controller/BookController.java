package com.sft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.dto.BookDTO;
import com.sft.exception.ResourceNotFoundException;
import com.sft.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${project.version}/books")
@Slf4j
public class BookController {

	@Autowired
	private BookService bookService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
		log.info("Add book api called. Data - {}", bookDTO);
		BookDTO response = bookService.addBook(bookDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		log.info("Get all book api called");
		List<BookDTO> response = bookService.getAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Long bookId) throws ResourceNotFoundException {
		log.info("Get book by ID api called. Book Id - {}", bookId);
		BookDTO response = bookService.getBookById(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
