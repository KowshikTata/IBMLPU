package com.example.demo.rest;

public class InstructorDetailNotFoundException extends Exception {
String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public InstructorDetailNotFoundException(String message) {
	super();
	this.message = message;
}

@Override
public String toString() {
	return "InstructorDetailNotFoundException [message=" + message + "]";
}


}
