package com.example.demo.rest;

public class EmployeeNotFoundException extends Exception {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public EmployeeNotFoundException(String message) {
	super();
	this.message = message;
}

@Override
public String toString() {
	return "EmployeeNotFoundException [message=" + message + "]";
}

}
