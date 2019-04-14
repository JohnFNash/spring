package com.johnfnash.learn.spring.tx.basic.service;

import java.util.List;

public interface CashierService {

	public void checkout(String username, List<String>isbns);
	
}
