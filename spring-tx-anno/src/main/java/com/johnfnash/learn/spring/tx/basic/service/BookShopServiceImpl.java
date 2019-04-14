package com.johnfnash.learn.spring.tx.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.johnfnash.learn.spring.tx.basic.repository.AccountRepository;
import com.johnfnash.learn.spring.tx.basic.repository.BookRepository;
import com.johnfnash.learn.spring.tx.basic.repository.BookStockRepository;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BookStockRepository bookStockRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			isolation = Isolation.READ_COMMITTED,
			readOnly = false,
			//noRollbackFor = RuntimeException.class,
			// rollbackFor = Exception.class,
			timeout = 3)
	@Override
	public void purchase(String username, String isbn) {
		//1.获取书的单价
		int price = bookRepository.findPriceByIsbn(isbn);
		//2.更新书的库存
		int updRes = bookStockRepository.updateBookStock(isbn);
		if(updRes == 0) {
			throw new RuntimeException("库存不足！");
		}
		//3.更新用户余额
		updRes = accountRepository.updateUserAccount(username, price);
		if(updRes == 0) {
			throw new RuntimeException("余额不足！");
		}
	}

}
