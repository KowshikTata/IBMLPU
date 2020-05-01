package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String schoolName;
	private String studentName;
	private String studentClass;
	private int studentRoll;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", schoolName=" + schoolName + ", studentName=" + studentName + ", studentClass="
				+ studentClass + ", studentRoll=" + studentRoll + "]";
	}
	public Student( String schoolName, String studentName, String studentClass, int studentRoll) {
		super();
		
		this.schoolName = schoolName;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentRoll = studentRoll;
	}
	
	
	
}
