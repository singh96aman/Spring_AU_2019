package com.spring.au.adapter;

public class Developer implements Employee {

	public double bonus=0.2;
	
	Developer(){
		System.out.println("Calculating Salary for Developer");
	}
	
	@Override
	public double salary(String type) {
		return basepay*bonus;
	}
	
}
