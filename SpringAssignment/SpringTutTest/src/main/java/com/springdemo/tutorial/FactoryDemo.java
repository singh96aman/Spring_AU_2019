package com.springdemo.tutorial;

public class FactoryDemo {
	private static final FactoryDemo obj=new FactoryDemo();  
	public static FactoryDemo getA(){  
	    System.out.println("factory method ");  
	    return obj;
	}  
}
