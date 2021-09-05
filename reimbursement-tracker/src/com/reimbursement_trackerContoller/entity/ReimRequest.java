 package com.reimbursement_trackerContoller.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimrequest")
public class ReimRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="requestorId")
	private int requestorId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private Date date;
	
	public void reimrequest() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReimRequest [id=" + id + ", requestorId=" + requestorId + ", amount=" + amount + ", purpose=" + purpose
				+ ", status=" + status + ", date=" + date + "]";
	}
	
	
}
