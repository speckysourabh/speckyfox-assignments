package com.sft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sft.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
