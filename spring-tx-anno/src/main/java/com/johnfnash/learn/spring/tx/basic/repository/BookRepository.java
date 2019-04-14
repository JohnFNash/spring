package com.johnfnash.learn.spring.tx.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.johnfnash.learn.spring.tx.basic.domain.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	@Query("select price from Book where isbn = ?1")
	public Integer findPriceByIsbn(String isbn);
	
}
