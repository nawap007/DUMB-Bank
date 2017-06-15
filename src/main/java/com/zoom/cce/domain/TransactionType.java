package com.zoom.cce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "transaction_type")
public class TransactionType {

	@Id
	@GeneratedValue
	@Column(name = "transaction_type_id")
	private long transactionTypeId;
	
	
	@Column(name = "transaction_type_name")
	private String transactionTypeName;

	@Column(name = "remarks")
	private String remarks;

	
	
	
	
	
	
	public TransactionType() {
		super();
	}

	public TransactionType(long transactionTypeId) {
		super();
		this.transactionTypeId = transactionTypeId;
	}

	public long getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
	
	
	
}
