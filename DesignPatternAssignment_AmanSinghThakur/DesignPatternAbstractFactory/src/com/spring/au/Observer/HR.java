package com.spring.au.Observer;

public class HR extends Observer{
	
	public HR(Employee employee){
		this.employee = employee;
		this.employee.attach(this);
	}

	@Override
	public void calculateGrossSalary() {
		System.out.println("Calculating Gross Salary for HR ");
	}

}
