package com.example.exception;

public class CustomerNotFoundException extends Exception {

	String message;

	
	
	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerNotFoundException [message=" + message + "]";
	}
	
	
	
}
