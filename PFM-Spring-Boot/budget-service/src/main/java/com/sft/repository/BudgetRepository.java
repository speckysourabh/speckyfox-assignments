package com.sft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sft.entity.BudgetEntity;

import feign.Param;

public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {
	
	public List<BudgetEntity> findByUserId(Long userId);
	
	@Query(nativeQuery = true, value = "select * from budget_entity where user_id = :userId and category = :category")
	public BudgetEntity findByUserIdAndCategory(@Param(value = "userId") Long userId, @Param(value = "category") String category);
}
