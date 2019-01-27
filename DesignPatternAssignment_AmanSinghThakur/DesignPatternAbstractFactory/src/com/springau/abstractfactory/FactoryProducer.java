package com.springau.abstractfactory;

public class FactoryProducer {
	
	   public static AbstractFactory getFactory(boolean isManagement){   
	      if(isManagement){
	         return new ManagementEmployeeFactory();         
	      }else{
	         return new NonManagementEmployeeFactory();
	      }
	   }
	}