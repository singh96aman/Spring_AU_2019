package com.spring.au.Observer;

public class Developer extends Observer{
	
	public Developer(Employee employee) {
		this.employee = employee;
		this.employee.attach(this);
	}

	@Override
	public void calculateGrossSalary() {
		System.out.println("Calculating Gross Salary for Developer");	
	}

}
