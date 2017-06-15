package com.zoom.cce.service;

import com.zoom.cce.service.dto.PullTransactionDTO;
import com.zoom.cce.service.dto.PushTransactionDTO;
import com.zoom.cce.service.dto.ResponseWrapper;

public interface TransactionService {
	
	public ResponseWrapper initiatePullTransation(PullTransactionDTO pullDTO);
	public ResponseWrapper getAllTransactions(String accNumber);
	public ResponseWrapper initiatePushTransation(PushTransactionDTO pushDTO);

}
