package com.zoom.cce.service.dto;


/**
 * @author shweta Class made to have a standard response.
 *
 * @param
 */
public class ResponseWrapper {
	
	boolean success;
	String responseCode;
	Object data;
	String responseMessage;
	
	public ResponseWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseWrapper(boolean success, String responseCode, String responseMessage) {
		super();
		this.success = success;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public ResponseWrapper(boolean success, String responseCode, Object data) {
		super();
		this.success = success;
		this.responseCode = responseCode;
		this.data = data;
	}

	public ResponseWrapper(boolean success, String responseCode, Object data, String responseMessage) {
		super();
		this.success = success;
		this.responseCode = responseCode;
		this.data = data;
		this.responseMessage = responseMessage;
	}

	

	public Object getData() {
		return data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
