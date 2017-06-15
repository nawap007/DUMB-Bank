package com.zoom.cce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="bank_account")
public class BankAccount {

	
	@JsonIgnore
	@Id
	@GeneratedValue
	@Column(name="bank_account_id")
	private long bankAccountId;
	
	
	@Column(name="bank_account_number")
	private String bankAccountNumber;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	private User user;

	
	@Column(name="bank_balance")
	private Double bankBalance; 
	
	@JsonIgnore
	@Column(name="accountStauts")
	private byte status; 
	
	
	
	
	



	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(Double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
