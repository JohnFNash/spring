package com.johnfnash.learn.spring.tx.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.johnfnash.learn.spring.tx.basic.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int updateUserAccount(String username, int price) {
		return accountRepository.updateUserAccount(username, price);
	}

}
