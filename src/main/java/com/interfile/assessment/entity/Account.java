package com.interfile.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "account")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "account_holder")
	private String accountHolder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Account(Integer id, String accountNumber, String accountHolder) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
}
