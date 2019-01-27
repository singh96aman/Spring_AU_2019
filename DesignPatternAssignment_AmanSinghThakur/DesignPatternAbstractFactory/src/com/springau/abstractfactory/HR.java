package com.springau.abstractfactory;

public class HR implements Employee{
	
	public double bonus=0.1;
	
	@Override
	public double salary() {
		System.out.print("Calculating Salary for HR");
		return basepay*bonus;
	}

}
