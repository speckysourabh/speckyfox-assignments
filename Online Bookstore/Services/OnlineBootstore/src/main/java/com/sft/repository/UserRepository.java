package com.sft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmail(String email);

}
