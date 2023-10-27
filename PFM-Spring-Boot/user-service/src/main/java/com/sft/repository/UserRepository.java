package com.sft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

}
