package com.sft.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sft.dto.ErrorDTO;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorDTO> customExceptionHandle(CustomException ex) {
		ErrorDTO errorDTO = new ErrorDTO(ex.getLocalizedMessage(), LocalTime.now().toString(), ex.getClass().getName());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDTO> resourceNotFoundException(ResourceNotFoundException ex) {
		ErrorDTO errorDTO = new ErrorDTO(ex.getLocalizedMessage(), LocalTime.now().toString(), ex.getClass().getName());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), LocalTime.now().toString(), ex.getClass().getName());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException ex) {
		ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), LocalTime.now().toString(), ex.getClass().getName());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorDTO> usernameNotFoundException(UsernameNotFoundException ex) {
		ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), LocalTime.now().toString(), ex.getClass().getName());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
	}

}