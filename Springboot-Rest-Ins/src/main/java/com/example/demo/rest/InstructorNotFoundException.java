package com.example.demo.rest;

public class InstructorNotFoundException extends Exception {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public InstructorNotFoundException(String message) {
	super();
	this.message = message;
}

@Override
public String toString() {
	return "InstructorNotFoundException [message=" + message + "]";
}


}
