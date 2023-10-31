package com.sft.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sft.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	public List<TransactionEntity> findByUserId(Long userId);

	@Query(nativeQuery = true, value =  "select * from transaction_entity where transaction_date > :filterDate and user_id = :userId")
	public List<TransactionEntity> findTransactionByFilterType(LocalDate filterDate, Long userId);

}
