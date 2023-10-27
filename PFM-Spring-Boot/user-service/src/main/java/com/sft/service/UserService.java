package com.sft.service;

import java.util.List;

import com.sft.entity.UserEntity;

public interface UserService {

	UserEntity getUser(Long userId) throws Exception;

	UserEntity addUser(UserEntity userEntity);

	List<UserEntity> getAllUser();

}
