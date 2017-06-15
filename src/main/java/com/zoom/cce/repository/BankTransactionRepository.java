package com.zoom.cce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoom.cce.domain.BankAccount;
import com.zoom.cce.domain.BankTransation;



@Repository
public interface BankTransactionRepository extends CrudRepository<BankTransation, Long>{
	
	public List<BankTransation> findByBankAccount(BankAccount acc);
	

}
