package com.johnfnash.learn.spring.tx;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnfnash.learn.spring.tx.basic.repository.BookRepository;
import com.johnfnash.learn.spring.tx.basic.service.AccountService;
import com.johnfnash.learn.spring.tx.basic.service.BookShopService;
import com.johnfnash.learn.spring.tx.basic.service.BookStockService;
import com.johnfnash.learn.spring.tx.basic.service.CashierService;

public class SpringTransactionTest {

	private ClassPathXmlApplicationContext context;
	private BookRepository bookRepository;
	private BookStockService bookStockService;
	private AccountService accountService;
	private BookShopService bookShopService;
	private CashierService cashierService;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("application.xml");
		bookRepository = context.getBean(BookRepository.class);
		bookStockService = context.getBean(BookStockService.class);
		accountService = context.getBean(AccountService.class);
		bookShopService = context.getBean(BookShopService.class);
		cashierService = context.getBean(CashierService.class);
	}

	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookRepository.findPriceByIsbn("1001"));
	}

	@Test
	public void tesUpdateBookStock() {
		bookStockService.updateBookStock("1001");
	}

	@Test
	public void testUpdateUserAccount() {
		accountService.updateUserAccount("nash", 100);
	}

	@Test
    public void testBookShopService(){
        bookShopService.purchase("nash", "1001");
    }
	
	@Test
    public void testTransactionPropagation(){
        cashierService.checkout("nash", Arrays.asList("1001", "1002"));
    }
	
	@After
	public void destroy() {
		if (context != null) {
			context.close();
		}
	}

}
