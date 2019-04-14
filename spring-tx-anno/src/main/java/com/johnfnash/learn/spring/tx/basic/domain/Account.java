package com.johnfnash.learn.spring.tx.basic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {

	@Id
	private String username;
	private Integer balance;
	
	public Account() {
	}

	public Account(String username, Integer balance) {
		this.username = username;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
