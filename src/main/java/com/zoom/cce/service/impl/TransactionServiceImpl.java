package com.zoom.cce.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoom.cce.domain.BankAccount;
import com.zoom.cce.domain.BankTransation;
import com.zoom.cce.domain.TransactionType;
import com.zoom.cce.repository.BankAccountRepository;
import com.zoom.cce.repository.BankTransactionRepository;
import com.zoom.cce.service.TransactionService;
import com.zoom.cce.service.dto.PullTransactionDTO;
import com.zoom.cce.service.dto.PushTransactionDTO;
import com.zoom.cce.service.dto.ResponseWrapper;
import com.zoom.cce.web.rest.util.BankConstants;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private BankTransactionRepository bankTransactionRepository;

	
	public ResponseWrapper getAllTransactions(String accNumber){
		
		try {
			
			BankAccount acc=bankAccountRepository.findByBankAccountNumberAndStatus(accNumber, (byte)1);
    		if(acc==null){
    			return new ResponseWrapper(false,"400FAIL",acc,"Invalid account number!!");
    		}
    		
    		List<BankTransation> trans=bankTransactionRepository.findByBankAccount(acc);
    		return new ResponseWrapper(true,"200SUCC",trans,"transations fetched successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false,"400FAIL","Some error occured!!");
		}
		
		
	}
	
	
	
	@Transactional
	@Override
	public ResponseWrapper initiatePullTransation(PullTransactionDTO pullDTO) {

		try {

			BankAccount acc = getAccount(pullDTO);
			if (acc == null) {
				return new ResponseWrapper(false, BankConstants.PULL_FAILURE_CODE, "Invalid Account number!!");
			}
			if (acc.getBankBalance() < pullDTO.getAmount()) {
				return new ResponseWrapper(false, BankConstants.PULL_INSUFFICIENT_FUNDS_CODE, "Insufficient Funds !!");
			}

			BankTransation transaction = prepareTransaction(acc, pullDTO);
			bankTransactionRepository.save(transaction);
			acc.setBankBalance(acc.getBankBalance() - pullDTO.getAmount());
			bankAccountRepository.save(acc);

			return new ResponseWrapper(true, BankConstants.PULL_SUCCESS_CODE, "Withdrawal successful!!");

		} catch (Exception e) {
			return new ResponseWrapper(false, BankConstants.PULL_FAILURE_CODE,
					"Problem occured while withdrawal please try after some time!!!");
		}
	}

	@Transactional
	@Override
	public ResponseWrapper initiatePushTransation(PushTransactionDTO pushDTO) {
		try {

			BankAccount acc = getAccount(pushDTO);

			if (acc == null) {
				return new ResponseWrapper(false, BankConstants.PUSH_FAIL_CODE, "Invalid Account number!!");
			}

			BankTransation transaction = prepareTransaction(acc, pushDTO);
			bankTransactionRepository.save(transaction);
			acc.setBankBalance(acc.getBankBalance() + pushDTO.getAmount());
			bankAccountRepository.save(acc);

			return new ResponseWrapper(true, BankConstants.PUSH_SUCCESS_CODE, "Deposit successful!!");

		} catch (Exception e) {
			return new ResponseWrapper(false, BankConstants.PUSH_FAIL_CODE,
					"Problem occured while Deposit please try after some time!!!");
		}
	}

	private BankTransation prepareTransaction(BankAccount acc, PullTransactionDTO pullDTO) {
		BankTransation transaction = new BankTransation();
		transaction.setAmount(pullDTO.getAmount());
		transaction.setBankAccount(acc);
		transaction.setTransactionDateTime(new Date());
		TransactionType type = new TransactionType(BankConstants.PULL_ID);
		transaction.setTransactionType(type);

		return transaction;
	}

	private BankTransation prepareTransaction(BankAccount acc, PushTransactionDTO pushDTO) {
		BankTransation transaction = new BankTransation();
		transaction.setAmount(pushDTO.getAmount());
		transaction.setBankAccount(acc);
		transaction.setTransactionDateTime(new Date());
		TransactionType type = new TransactionType(BankConstants.PUSH_ID);
		transaction.setTransactionType(type);

		return transaction;
	}

	private BankAccount getAccount(PullTransactionDTO pullDTO) {

		BankAccount acc = bankAccountRepository.getAccountByBankAccountNumberAndStatus(pullDTO.getAccountNumber(),
				(byte) 1);

		return acc;

	}

	private BankAccount getAccount(PushTransactionDTO pushDTO) {

		BankAccount acc = bankAccountRepository.getAccountByBankAccountNumberAndStatus(pushDTO.getAccountNumber(),
				(byte) 1);

		return acc;

	}

}
