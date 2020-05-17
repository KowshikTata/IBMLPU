package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Employee {

	private int id;
	private String firstName;
	private String lastname;
	private String email;
	private int departmentId;
	private String departmentName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
