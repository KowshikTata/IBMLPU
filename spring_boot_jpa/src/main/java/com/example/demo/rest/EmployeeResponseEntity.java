package com.example.demo.rest;

public class EmployeeResponseEntity {

	private int statuscode;
	private String message;
	private long time;
	public EmployeeResponseEntity(int statuscode, String message, long time) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.time = time;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "EmployeeResponseEntity [statuscode=" + statuscode + ", message=" + message + ", time=" + time + "]";
	}
	
	
}
