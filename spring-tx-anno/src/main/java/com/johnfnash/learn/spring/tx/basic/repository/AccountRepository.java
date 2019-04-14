package com.johnfnash.learn.spring.tx.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.johnfnash.learn.spring.tx.basic.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	@Modifying
	@Query("update Account set balance = balance - ?2 where username = ?1 and balance >= ?2")
	public int updateUserAccount(String username, int price);
	
}
