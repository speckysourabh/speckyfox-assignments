package com.sft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	public List<TransactionEntity> findByUserId(Long userId);
}
