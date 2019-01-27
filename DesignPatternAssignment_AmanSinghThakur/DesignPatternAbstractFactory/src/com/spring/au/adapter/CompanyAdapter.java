package com.spring.au.adapter;

public class CompanyAdapter implements CompanyBonus {
	
	Employee employee;
	String companyName;
	public double bonus;
	
	public CompanyAdapter(String companyName, String type) {
		this.companyName=companyName;
		if(type.equalsIgnoreCase("Developer"))
			employee = new Developer();
		else if(type.equalsIgnoreCase("HR"))
			employee = new HR();
	}

	@Override
	public void assignBonus() {	
		if(companyName.equalsIgnoreCase("Accolite"))
			bonus=0.5;
		else
			bonus=0.2;
		
	}

}
