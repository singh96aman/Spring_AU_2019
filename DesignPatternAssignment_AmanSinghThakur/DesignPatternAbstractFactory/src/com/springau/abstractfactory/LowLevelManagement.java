package com.springau.abstractfactory;

public class LowLevelManagement implements Employee{

	public double bonus=0.3;
	
	@Override
	public double salary() {
		System.out.print("Calculating Salary for LowLevelManagement");
		return basepay*bonus;
	}

}
