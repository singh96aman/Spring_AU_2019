package com.spring.au.Observer;

public class DriverClass {

	public static void main(String[] args) {
		Employee employee = new Employee();
		new Developer(employee);
		new HR(employee);
		new CEO(employee);
		System.out.println("Setting Salary 100000");
		employee.setSalary(100000);
		System.out.println("Setting Salary 500000");
		employee.setSalary(500000);
	}
	
}
