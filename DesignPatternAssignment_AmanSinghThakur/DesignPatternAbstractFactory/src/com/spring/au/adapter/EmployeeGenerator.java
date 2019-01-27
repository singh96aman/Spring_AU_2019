package com.spring.au.adapter;

public class EmployeeGenerator implements Employee{
	
	CompanyAdapter adapter;

	@Override
	public double salary(String type) {
		if(type.equalsIgnoreCase("Developer")){
				adapter = new CompanyAdapter("Accolite", "Developer");
				adapter.assignBonus();
				return basepay*adapter.bonus;
			}
			else if(type.equalsIgnoreCase("HR")){
				adapter = new CompanyAdapter("Accolite", "HR");
				adapter.assignBonus();
				return basepay*adapter.bonus;
			}else {
				System.out.println("Other Type of Employee not supported");
				return 0;
			}
	}

}
