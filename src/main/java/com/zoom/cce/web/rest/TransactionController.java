package com.zoom.cce.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoom.cce.service.TransactionService;
import com.zoom.cce.service.dto.PullTransactionDTO;
import com.zoom.cce.service.dto.PushTransactionDTO;
import com.zoom.cce.service.dto.ResponseWrapper;

@RestController
@RequestMapping("transaction/")
public class TransactionController {

	@Autowired
	private TransactionService pullService;
	
	@GetMapping(value="all/{acc}")
	public ResponseWrapper pull(@PathVariable("acc") String accNumber ){
		
		
		return pullService.getAllTransactions(accNumber);
	}
	
	@PostMapping(value="pull")
	public ResponseWrapper pull(@RequestBody PullTransactionDTO pullDTO ){
		
		
		return pullService.initiatePullTransation(pullDTO);
	}
	
	@PostMapping(value="push")
	public ResponseWrapper push(@RequestBody PushTransactionDTO pushDTO ){
		
		
		return pullService.initiatePushTransation(pushDTO);
	}
	
	
}
