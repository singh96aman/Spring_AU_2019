package com.springdemo.tutorial;

public class Student {
	
	private String studentId;
	private String studentName;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String toString() {
		return this.studentName+" "+this.studentId;
	}
}
