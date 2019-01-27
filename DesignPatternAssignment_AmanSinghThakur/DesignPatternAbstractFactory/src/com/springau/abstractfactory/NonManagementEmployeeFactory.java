package com.springau.abstractfactory;

public class NonManagementEmployeeFactory extends AbstractFactory{

	@Override
	Employee getEmployeeType(String employeeType) {
		if(employeeType.equalsIgnoreCase("Developer")){
	         return new Developer();      
	      }else if(employeeType.equalsIgnoreCase("HR")){
	         return new HR();
	      }	 
	      return null;
	}
}
