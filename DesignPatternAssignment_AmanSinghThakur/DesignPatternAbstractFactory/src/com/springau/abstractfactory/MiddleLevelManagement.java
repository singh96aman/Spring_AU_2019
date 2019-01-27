package com.springau.abstractfactory;

public class MiddleLevelManagement implements Employee{

	public double bonus=0.4;
	
	@Override
	public double salary() {
		System.out.print("Calculating Salary for MiddleLevelManagement");
		return basepay*bonus;
	}

}
