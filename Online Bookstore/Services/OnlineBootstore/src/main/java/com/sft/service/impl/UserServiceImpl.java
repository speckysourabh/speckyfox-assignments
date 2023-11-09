package com.sft.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sft.config.CustomUser;
import com.sft.dto.UpdatePasswordDTO;
import com.sft.dto.UserDTO;
import com.sft.dto.UserLoginDTO;
import com.sft.entity.UserEntity;
import com.sft.exception.CustomException;
import com.sft.exception.UserNotFoundException;
import com.sft.repository.UserRepository;
import com.sft.service.UserService;
import com.sft.service.security.JwtService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Override
	public UserDTO register(UserDTO userResponseDTO) throws CustomException {
		UserEntity userEntity = modelMapper.map(userResponseDTO, UserEntity.class);
		if (isUserExist(userEntity.getEmail())) {
			throw new CustomException("You are already registered with us");
		}
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		return modelMapper.map(userRepository.save(userEntity), UserDTO.class);
	}

	@Override
	public boolean isUserExist(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	@Override
	public UserDTO updateUserPassword(UpdatePasswordDTO updatePasswordDTO)
			throws UserNotFoundException, CustomException {

		if (!updatePasswordDTO.getNewPassword().equals(updatePasswordDTO.getConfirmPassword())) {
			throw new CustomException("New password and confirm password is not matched");
		}

		UserEntity userEntity = this.getUserByEmail(updatePasswordDTO.getEmail());

		if (!passwordEncoder.matches(updatePasswordDTO.getCurrentPassword(), userEntity.getPassword())) {
			throw new CustomException("Current password is not correct");
		}

		userEntity.setPassword(passwordEncoder.encode(updatePasswordDTO.getNewPassword()));

		return modelMapper.map(userRepository.save(userEntity), UserDTO.class);
	}

	@Override
	public UserEntity getUserById(Long id) throws UserNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User doesn't exist having id " + id));
	}

	@Override
	public UserEntity getUserByEmail(String email) throws UserNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User doesn't exist having id " + email));
	}

	@Override
	public String isUserAuthenticated(UserLoginDTO userLoginDTO) throws UserNotFoundException {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userLoginDTO.getEmail(), userLoginDTO.getPassword());
		try {
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			return jwtService.generateToken(((CustomUser)authentication.getPrincipal()));
		} catch (AuthenticationException authenticationException) {
			throw new UserNotFoundException("User not found !");
		} catch (Exception exception) {
			throw new UserNotFoundException("User not found !");
		}
	}

}