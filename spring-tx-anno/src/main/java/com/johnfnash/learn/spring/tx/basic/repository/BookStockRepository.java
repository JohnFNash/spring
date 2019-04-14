package com.johnfnash.learn.spring.tx.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.johnfnash.learn.spring.tx.basic.domain.BookStock;

public interface BookStockRepository extends JpaRepository<BookStock, String> {

	@Modifying
	@Query("update BookStock set stock = stock - 1 where isbn = ?1 and stock > 0")
	public int updateBookStock(String isbn);
	
}
