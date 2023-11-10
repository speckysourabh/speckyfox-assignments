package com.sft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.PurchaseEntity;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

	Optional<PurchaseEntity> findByUserEmailAndBookId(String userEmail, Long bookId);

}
