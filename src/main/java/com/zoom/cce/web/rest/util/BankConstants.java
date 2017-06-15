package com.zoom.cce.web.rest.util;

public interface BankConstants {

	String PULL_FAILURE_CODE = "400PULLFAIL";
	String PULL_SUCCESS_CODE = "200PULLSUCC";

	String PUSH_FAIL_CODE = "200PUSHFAIL";
	String PUSH_SUCCESS_CODE = "200PUSHSUCC";

	String PUSH_INVALID_ACCOUNT_CODE = "401ACCINV";
	String PULL_INSUFFICIENT_FUNDS_CODE = "402INSFUND";
	Long PUSH_ID = 1l;
	Long PULL_ID = 2l;
	

}
