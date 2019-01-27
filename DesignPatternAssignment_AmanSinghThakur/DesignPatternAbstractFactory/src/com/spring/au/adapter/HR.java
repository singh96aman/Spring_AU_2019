package com.spring.au.adapter;

public class HR implements Employee{

public double bonus=0.1;

	HR(){
		System.out.println("Calculating Salary for HR");
	}
	
	@Override
	public double salary(String type) {
		return basepay*bonus;
	}
	
}
