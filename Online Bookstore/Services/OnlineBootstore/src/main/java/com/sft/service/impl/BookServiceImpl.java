package com.sft.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sft.dto.BookDTO;
import com.sft.entity.BookEntity;
import com.sft.exception.ResourceNotFoundException;
import com.sft.repository.BookRepository;
import com.sft.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookDTO addBook(BookDTO bookDTO) {
		BookEntity bookEntity = bookRepository.save(modelMapper.map(bookDTO, BookEntity.class));
		return modelMapper.map(bookEntity, BookDTO.class);
	}

	@Override
	public List<BookDTO> getAllBooks() {
		Type listType = new TypeToken<List<BookDTO>>() {
		}.getType();
		List<BookEntity> response = bookRepository.findAll();
		return modelMapper.map(response, listType);
	}

	@Override
	public BookDTO getBookById(Long bookId) throws ResourceNotFoundException {
		BookEntity response = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("No book exists having id "+bookId));
		return modelMapper.map(response, BookDTO.class);
	}

	@Override
    public void deleteBookById(Long bookId) throws ResourceNotFoundException {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));
        bookRepository.delete(bookEntity);
    }
	
	@Override
	public void updateBookById(BookDTO bookDTO) throws ResourceNotFoundException {
	    BookEntity existingBook = bookRepository.findById(bookDTO.getId())
	            .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookDTO.getId()));

	    ModelMapper modelMapper = new ModelMapper();
	    modelMapper.map(bookDTO, existingBook);

	    bookRepository.save(existingBook);
	}


}
