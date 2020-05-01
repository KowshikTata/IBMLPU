package com.example.demo.exception;

public class UserResponseEntity {

	private int statuscode;
	private String message;
	private Long time;
	public UserResponseEntity(int statuscode, String message, Long time) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserResponseEntity [statuscode=" + statuscode + ", message=" + message + ", time=" + time + "]";
	}
	public UserResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	
	
}
