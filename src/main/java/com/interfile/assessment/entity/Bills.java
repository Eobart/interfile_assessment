package com.interfile.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

	@Column(name = "period")
	private String period;
	
	@Column(name = "charges")
	private String charges;
	
	@Column(name = "outstanding")
	private String outstanding;
	
	@Column(name = "due_date")
	private String dueDate;

	public Bills() {}
	
	public Bills(Integer id, String billDate, String period, String charges, String outstanding, String dueDate) {
		super();
		this.id = id;
		this.billDate = billDate;
		this.period = period;
		this.charges = charges;
		this.outstanding = outstanding;
		this.dueDate = dueDate;
	}
}
