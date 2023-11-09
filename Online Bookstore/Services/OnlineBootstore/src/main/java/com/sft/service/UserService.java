package com.sft.service;

import com.sft.dto.UpdatePasswordDTO;
import com.sft.dto.UserDTO;
import com.sft.dto.UserLoginDTO;
import com.sft.entity.UserEntity;
import com.sft.exception.CustomException;
import com.sft.exception.UserNotFoundException;

public interface UserService {

	UserDTO register(UserDTO userResponseDTO) throws CustomException;

	boolean isUserExist(String email);

	UserDTO updateUserPassword(UpdatePasswordDTO updatePasswordDTO) throws UserNotFoundException, CustomException;
	
	UserEntity getUserById(Long id) throws UserNotFoundException;
	
	UserEntity getUserByEmail(String email) throws UserNotFoundException;

	String isUserAuthenticated(UserLoginDTO userLoginDTO) throws UserNotFoundException;

}
