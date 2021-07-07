package com.interfile.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Bills")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Bills {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "bill_date")
	private String billDate;

	@Column(name = "period")
	private String period;
	
	@Column(name = "charges")
	private String charges;
	
	@Column(name = "outstanding")
	private String outstanding;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appointmentStatus", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public String getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(String outstanding) {
		this.outstanding = outstanding;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Bills() {}

	public Bills(Integer id, String billDate, String period, String charges, String outstanding, String dueDate, Account account) {
		super();
		this.id = id;
		this.billDate = billDate;
		this.period = period;
		this.charges = charges;
		this.outstanding = outstanding;
		this.dueDate = dueDate;
		this.account = account;
	}
}
