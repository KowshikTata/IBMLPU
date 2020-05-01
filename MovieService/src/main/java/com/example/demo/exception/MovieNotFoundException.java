package com.example.demo.exception;

public class MovieNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public MovieNotFoundException(String message) {
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
		return "MovieNotFoundException [message=" + message + "]";
	}
	
	
	
}
