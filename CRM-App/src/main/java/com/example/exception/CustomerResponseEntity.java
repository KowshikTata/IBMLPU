package com.example.exception;

public class CustomerResponseEntity {

	int statusCode;
	String message;
	long seconds;
	public CustomerResponseEntity(int statusCode, String message, long seconds) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.seconds = seconds;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getSeconds() {
		return seconds;
	}
	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}
	
}
