package com.springau.abstractfactory;

public class MainDriver {
	
	public static void main(String[] args) {
		boolean isManagement = true;
		
		AbstractFactory abstractFactoryForManagement = FactoryProducer.getFactory(isManagement);
		Employee emp1 = abstractFactoryForManagement.getEmployeeType("TopLevelManagement");
		System.out.print(" = "+emp1.salary()+" \n");
		Employee emp2 = abstractFactoryForManagement.getEmployeeType("MiddleLevelManagement");
		System.out.print(" = "+emp2.salary()+" \n");
		Employee emp3 = abstractFactoryForManagement.getEmployeeType("LowLevelManagement");
		System.out.print(" = "+emp3.salary()+" \n");
		
		isManagement = false;
		
		AbstractFactory abstractFactoryForNonManagement = FactoryProducer.getFactory(isManagement);
		Employee emp4 = abstractFactoryForNonManagement.getEmployeeType("Developer");
		System.out.print(" = "+emp4.salary()+" \n");
		Employee emp5 = abstractFactoryForNonManagement.getEmployeeType("HR");
		System.out.print(" = "+emp5.salary()+" \n");
		
	}

}
