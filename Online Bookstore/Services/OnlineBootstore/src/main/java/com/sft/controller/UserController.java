package com.sft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.dto.UpdatePasswordDTO;
import com.sft.dto.UserDTO;
import com.sft.exception.CustomException;
import com.sft.exception.UserNotFoundException;
import com.sft.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${project.version}/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> userRegistration(@Valid @RequestBody UserDTO userResponseDTO)
			throws CustomException {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userResponseDTO));
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@Valid @RequestBody UserDTO userDTO) throws UserNotFoundException {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.isUserAuthenticated(userDTO));
	}

	@PutMapping("/update-password")
	public ResponseEntity<UserDTO> updatePassword(@Valid @RequestBody UpdatePasswordDTO updatePasswordDTO)
			throws UserNotFoundException, CustomException {
		log.info("Update password api called. Data - "+updatePasswordDTO);
		UserDTO userDTO = userService.updateUserPassword(updatePasswordDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

}
