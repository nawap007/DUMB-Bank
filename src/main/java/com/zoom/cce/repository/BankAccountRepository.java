package com.zoom.cce.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoom.cce.domain.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long>{
	
	
	@Query(value="select * from bank_account where bank_account_number=:acc and status=:status for update")		
	public BankAccount getAccountByBankAccountNumberAndStatus(@Param("acc")String accNumber,@Param("status")byte status);
	
	
	public BankAccount findByBankAccountNumberAndStatus(String accNumber,byte status);
	
	
	

}
