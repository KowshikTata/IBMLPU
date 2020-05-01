package com.example.demo.exception;

public class MovieResponseEntity {

	private int statuscode;
	private String message;
	private Long time;
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
	@Override
	public String toString() {
		return "MovieResponseEntity [statuscode=" + statuscode + ", message=" + message + ", time=" + time + "]";
	}
	public MovieResponseEntity(int statuscode, String message, Long time) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.time = time;
	}
	public MovieResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
