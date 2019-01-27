package com.spring.au.Observer;

public class CEO extends Observer{

	public CEO(Employee employee) {
		this.employee = employee;
		this.employee.attach(this);
	}
	
	@Override
	public void calculateGrossSalary() {
		System.out.println("Calculating Gross Salary for CEO");		
	}

}
