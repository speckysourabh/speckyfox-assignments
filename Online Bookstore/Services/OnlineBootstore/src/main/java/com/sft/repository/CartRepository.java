package com.sft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sft.entity.CartEntity;

import jakarta.transaction.Transactional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

	List<CartEntity>  findByUserEmail(String userName);

	@Modifying
    @Transactional
	@Query(nativeQuery = true, value = "delete from cartitems where user_email = :userName and book_id = :bookId")
	void deleteItem(@Param("userName") String userName, @Param("bookId") Long bookId);

	void deleteByUserEmailAndBookId(String userName, Long bookId);

}
