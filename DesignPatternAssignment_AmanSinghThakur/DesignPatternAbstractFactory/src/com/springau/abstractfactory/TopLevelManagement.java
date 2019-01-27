package com.springau.abstractfactory;

public class TopLevelManagement implements Employee{

	public double bonus=0.5;
	
	@Override
	public double salary() {
		System.out.print("Calculating Salary for TopLevelManagement");
		return basepay*bonus;
	}

}
