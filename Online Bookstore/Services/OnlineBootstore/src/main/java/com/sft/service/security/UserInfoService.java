package com.sft.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sft.config.CustomUser;
import com.sft.entity.UserEntity;
import com.sft.repository.UserRepository; 

@Service
public class UserInfoService implements UserDetailsService { 

	@Autowired
	private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		Optional<UserEntity> userEntity = userRepository.findByEmail(username); 

		if(userEntity.isEmpty() ) {
			throw new UsernameNotFoundException("User not found " + username);
		}
		return new CustomUser(userEntity.get()); 
	} 

}