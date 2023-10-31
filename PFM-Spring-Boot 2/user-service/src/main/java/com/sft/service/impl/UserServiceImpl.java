package com.sft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sft.entity.UserEntity;
import com.sft.repository.UserRepository;
import com.sft.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity getUser(Long userId) throws Exception {
		return userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
	}

	@Override
	public UserEntity addUser(UserEntity userEntity) {
		log.info("Data - {}", userEntity);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(userEntity.getPassword());
		userEntity.setPassword(password);
		return userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}

}
