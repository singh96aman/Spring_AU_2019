package com.springau.abstractfactory;

public class ManagementEmployeeFactory extends AbstractFactory {

	@Override
	Employee getEmployeeType(String employeeType) {
		 if(employeeType.equalsIgnoreCase("TopLevelManagement")){
	         return new TopLevelManagement();     
	      }else if(employeeType.equalsIgnoreCase("MiddleLevelManagement")){
	         return new MiddleLevelManagement();
	      }else if(employeeType.equalsIgnoreCase("LowLevelManagement")){
	    	  return new LowLevelManagement();
	      }
	      return null;
	}

}
