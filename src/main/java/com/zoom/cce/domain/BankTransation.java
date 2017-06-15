package com.zoom.cce.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "bank_transaction")
public class BankTransation {

	@Id
	@GeneratedValue
	@Column(name = "bank_transaction_id")
	private long bankTransactionId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_account_fk", nullable = true)
	private BankAccount bankAccount;

	@Column(name = "amount")
	private double amount;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transaction_type_fk", nullable = true)
	private TransactionType transactionType;
	
	@Column(name = "transaction_date_time")
	private Date transactionDateTime;

	public long getBankTransactionId() {
		return bankTransactionId;
	}

	
	
	public void setBankTransactionId(long bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	
	
	
	
	
	
	
}
