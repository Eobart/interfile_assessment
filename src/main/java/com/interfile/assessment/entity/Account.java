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
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "home_number")
	private String homeNumber;
	
	@Column(name = "work_number")
	private String workNumber;
	
	@Column(name = "address_1")
	private String address1;
	
	@Column(name = "address_2")
	private String address2;
	
	@Column(name = "address_3")
	private String address3;
	
	@Column(name = "postal_code")
	private String postalCode;
	
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Account() {}

	public Account(Integer id, String accountNumber, String accountHolder, String mobileNumber, String homeNumber,
			String workNumber, String address1, String address2, String address3, String postalCode) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.mobileNumber = mobileNumber;
		this.homeNumber = homeNumber;
		this.workNumber = workNumber;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.postalCode = postalCode;
	}

	
}
