package com.johnfnash.learn.spring.tx.basic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_book_stock")
public class BookStock {

	@Id
	private String isbn;
	private int stock;
	
	public BookStock() {
	}

	public BookStock(String isbn, int stock) {
		this.isbn = isbn;
		this.stock = stock;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
