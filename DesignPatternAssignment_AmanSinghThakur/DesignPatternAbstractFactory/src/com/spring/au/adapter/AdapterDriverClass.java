package com.spring.au.adapter;

public class AdapterDriverClass {

	public static void main(String[] args) {
		EmployeeGenerator employee = new EmployeeGenerator();
		System.out.println(employee.salary("Developer"));
		System.out.println(employee.salary("HR"));
		System.out.println(employee.salary("CEO"));
		
	}
	
}
