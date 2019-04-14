package com.johnfnash.learn.spring.tx.basic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book {

	@Id
	private String isbn;
	private String name;
	private Integer price;

	public Book() {
	}

	public Book(String isbn, String name, Integer price) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
