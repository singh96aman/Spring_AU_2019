/* EMPLOYEE MANAGEMENT SYSTEM PROGRAM CREATED BY AMAN SINGH THAKUR
 * Made on : 12th January, 2019
 * Topic : Core Java
 * Sub Topics : packages, classes, constructor, function overloading, function overrriding, abstraction, abstract, interface
 * 				inheritance, algorithms, collections, treeset, arraylist, iterator, sorting, enum
 */

//package Assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Address{
	String local, city, pincode;
	Address(String local, String city, String pincode){
		this.local=local;
		this.city=city;
		this.pincode=pincode;
	}
}

class Company{
	String name, companyID;
	Address address;
	TreeSet<Person> Employees;
	Company(String name, String companyID, Address address){
		this.name=name;
		this.companyID=companyID;
		this.address=address;
		Employees = new TreeSet<Person>((p1,p2) -> 
			(p1.age<p2.age ? -1 : (p1.age==p2.age ? 0 : 1))
		);
	}
	
	void resetEmployees(TreeSet<Person> ts) {
		Employees = ts;
	}
	
	void addEmployee(Person p){
		Employees.add(p);
	}
	TreeSet<Person> getAllEmployee(Person p){
		return Employees;
	}
	Person getEmployee(String id) {
		Iterator<Person> i = Employees.iterator();
		while(i.hasNext()) {
			Person p = i.next();
			if(p.id.equals(id))
				return p;
		}
		return null;
	}
	void getAllEmployees() {
		Iterator<Person> i = Employees.iterator();
		while(i.hasNext()) {
			Person p = i.next();
			System.out.println(p);
		}
	}
}

class Person{
	String name; int age; String id;
	Person(String name, int age, String id){
		this.name = name;
		this.age = age;
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		Person that = (Person) obj;
		return (this.name.equals(that.name) && (this.age == that.age) && (this.id.equals(this.id)));
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public String toString() {
		return this.name+" "+this.age+" "+this.id;
	}
	
	//Assignment (given by trainer) to sort according to descending order of age
	/*
	@Override
	public int compareTo(Person o) {
		if(o.age>this.age)
			return 1;
		else if(o.age==this.age)
			return 0;
		else
			return -1;
			
	}*/
}

public class AdvanceJavaProjects {
	
	static enum SortType {
		AGE,
		NAME,
		ID
	}
	
	static void getAllEmployeesWithAgeLessThan30(ArrayList<Company> companies) {
		System.out.println("/********All Employees Less Than 30*********/");
		for(int i=0; i<companies.size(); i++) {
			System.out.println(companies.get(i).name);
			Iterator<Person> iterator = companies.get(i).Employees.iterator();
			while(iterator.hasNext()) {
				Person p = iterator.next();
				if(p.age<=30)
					System.out.println(p);
			}
		}
	}

	static void getAllEmployeesInSameCity(ArrayList<Company> companies) {
		System.out.println("/********All Employees In Same City*********/");
		for(int i=0; i<companies.size(); i++) {
			for(int j=0; j<i; j++) {
				if(i!=j) {
					if(companies.get(i).address.city.equals(companies.get(i).address.city))
							System.out.println("All Employees of "+companies.get(i).name+" and "+companies.get(j).name+" have employees in "+companies.get(i).address.city);
				}
			}
		}
	}
	
	static void sortEmployees(ArrayList<Company> companies, SortType sorttype) {
		TreeSet<Person> ts;
		switch(sorttype) {
			case AGE 	: 	System.out.println("/********Sorting By Age*********/");
							ts = new TreeSet<Person>((p1,p2) -> 
							(p1.age<p2.age ? -1 : (p1.age==p2.age ? 0 : 1))
									);
							break;
			case NAME 	:	System.out.println("/********Soring By Name*********/");
							ts = new TreeSet<Person>((p1,p2) -> p1.name.compareTo(p2.name));
							break; 
			case ID 	: 	System.out.println("/********Sorting By ID*********/");
							ts = new TreeSet<Person>((p1,p2) -> p1.id.compareTo(p2.id));
							break;
			default 	: 	return;
		}
		for(int i=0; i<companies.size(); i++) {
			Iterator<Person> iterator = companies.get(i).Employees.iterator();
			while(iterator.hasNext()) {
				Person p = iterator.next();
				ts.add(p);
			}
			companies.get(i).resetEmployees(ts);
		}	
		companies.get(0).getAllEmployees();
	}
	
	public static void main(String[] args) {
		ArrayList<Company> companies = new ArrayList<Company>();
		
		// Addition in O(nlog(n)) time
		companies.add(new Company("Accolite","acc123", new Address("Umaiya Business Bay 1","Bangalore","576103")));
		companies.add(new Company("Cisco","cis345", new Address("Cessna","Bangalore","576903")));
		companies.get(0).addEmployee(new Person("abc",12,"v13be2")); companies.get(0).addEmployee(new Person("sdf",9,"vbe342")); companies.get(0).addEmployee(new Person("sad",90,"fsd32"));
		companies.get(0).addEmployee(new Person("sda",67,"45be2")); companies.get(0).addEmployee(new Person("wqd",56,"a56be2")); companies.get(0).addEmployee(new Person("asd",8,"vasdbe2"));
		companies.get(1).addEmployee(new Person("cd",56,"v132e2")); companies.get(1).addEmployee(new Person("few",45,"bhf2")); companies.get(1).addEmployee(new Person("cbh",234,"mbvbe2"));
		companies.get(1).addEmployee(new Person("sadd",89,"vbe12")); companies.get(1).addEmployee(new Person("dsw",34,"dshf3")); companies.get(1).addEmployee(new Person("kjhg",345,"sae2")); 
		
		//Search in O(1) time
		getAllEmployeesWithAgeLessThan30(companies);
		//Search in O(n^2) time
		getAllEmployeesInSameCity(companies);
		
		//Sort in O(nlogn) time
		sortEmployees(companies, SortType.AGE);
		sortEmployees(companies, SortType.NAME);
		sortEmployees(companies, SortType.ID);
	}
}
