package com.spring.au.Observer;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private List<Observer> observers = new ArrayList<Observer>();
	private int salary;
	
	public List<Observer> getObservers() {
		return observers;
	}
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
		notifyAllObservers();
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer observer : observers) {
			observer.calculateGrossSalary();
		}
	}
	
}
