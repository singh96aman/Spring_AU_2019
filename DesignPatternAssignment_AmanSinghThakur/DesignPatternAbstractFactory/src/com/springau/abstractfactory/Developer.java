package com.springau.abstractfactory;

public class Developer implements Employee {
	
	public double bonus=0.2;
	
	@Override
	public double salary() {
		System.out.print("Calculating Salary for Developer");
		return basepay*bonus;
	}

}
