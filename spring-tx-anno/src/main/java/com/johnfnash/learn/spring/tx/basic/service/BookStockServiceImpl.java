package com.johnfnash.learn.spring.tx.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.johnfnash.learn.spring.tx.basic.repository.BookStockRepository;

@Service("bookStockService")
public class BookStockServiceImpl implements BookStockService {

	@Autowired
	private BookStockRepository bookStockRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int updateBookStock(String isbn) {
		return bookStockRepository.updateBookStock(isbn);
	}

}
