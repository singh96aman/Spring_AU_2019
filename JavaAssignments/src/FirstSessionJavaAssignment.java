/*
* Simple Employee program made by Aman Singh Thakur
* Made on : 12th January, 2019
* Topics : Core Java
* Sub Topics : 	Packages, import, interface, class, constructor, static function, static block, normal block, function overloading
*				function overrriding, collections, arraylist, OOP, Datatypes, Exception Handling, covariant return type
*/
//package Assignment;

import java.util.ArrayList;

interface Salary{
	abstract void calculateBonus(double salary);
}

class EmployeeDB{
	public EmployeeDB() {
		System.out.println("Getting Data from EmployeeDB");
	}
}

class ManagerDB extends EmployeeDB{
	public ManagerDB() {
		System.out.println("Getting Data from ManagerDB");
	}
}

class Employee{
	protected String name, empID;
	protected int age;
	static int count=0;
	
	static {
		System.out.println("Creating a Employee Position");
	}
	
	String designation;
	
	Employee(String name, String empID, int age){
		this.name = name;
		this.empID = empID;
		this.age = age;
	}
	
	static void getCount() {
		count++;
	}
	
	@Override
	public String toString() {
		return "Employee is "+this.name+" with Employee ID "+this.empID+" Age "+this.age;
	}
	
	public EmployeeDB getDetails() {
		return new EmployeeDB();
	}
	
}

// Example of Single Inheritance of class and interface
class Manager extends Employee implements Salary{

	
	static {
		System.out.println("Creating a Manager Position");
	}
	
	Manager(String name, String empID, int age){
		super(name, empID, age);
		this.designation = "Manager";
	}
	
	@Override
	public String toString() {
		return "Manager is "+this.name+" with Employee ID "+this.empID+" Age "+this.age+" Designation "+this.designation+"\n"	;
	}

	@Override
	public void calculateBonus(double salary) {
		System.out.println(salary*1.2);
	}
	
	public ManagerDB getDetails() {
		return new ManagerDB();
	}
	
}

class Technical extends Employee implements Salary{
	
	static {
		System.out.println("Creating a Technical Position");
	}
	{
		System.out.println("Brain Washing..."); // Called Everytime An Object of Technical is created !
	}
	
	Technical(String name, String empID, int age){
		super(name, empID, age);
		this.designation = "Technical";
	}
	
	@Override
	public String toString() {
		return "Technical is "+this.name+" with Employee ID "+this.empID+" Age "+this.age+" Designation "+this.designation+"\n";
	}

	@Override
	public void calculateBonus(double salary) {
		System.out.println(salary*1.5);
	}
	
}

/* MAIN CLASS */
public class FirstSessionJavaAssignment {
	
	static double salaryTechnical = 50000, salaryManager = 100000;
	
	public static void main(String[] args) {
		/*All Data*/
		
		String[] managerName = {"aman","baman","chaman","khaman","pawan","hawan","naman","daman","sanam"};
		String[] managerempID = {"abc123","abc124","abc125","abc126","abc127","abc128","abc129","abc130","abc131"};
		int[] managerAge = {21,34,12,45,67,23,12,89,23};
		
		String[] technicalName = {"a1","a2","a3","a4","a5","a6","a7","a8","a9"};
		String[] technicalID = {"pqr123","pqr124","pqr125","pqr126","pqr127","pqr128","pqr129","pqr130","pqr131"};
		int[] techAge = {34,10,45,12,45,21,14,53,78};
		
		ArrayList<Manager> managers = new ArrayList<Manager>(managerName.length);
		ArrayList<Technical> technical = new ArrayList<Technical>(technicalName.length);
		
		/*Add Data*/
		for(int i=0; i<managerName.length; i++) {
			managers.add(new Manager(managerName[i], managerempID[i], managerAge[i]));
			Employee.count++;
			technical.add(new Technical(technicalName[i], technicalID[i], techAge[i]));
			Employee.count++;
		}
		
		// Print Data
		for(int i=0; i<managerName.length; i++) {
			System.out.println(managers.get(i)+" "+technical.get(i));
		}
		
		//Calculate Bonus
		Manager tempManager = managers.get(0);
		System.out.print("Final Salary of Manager : "); 
		tempManager.calculateBonus(salaryManager);
		
		Technical tempTechnical = technical.get(0);
		System.out.print("Final Salary of Technical is : ");
		tempTechnical.calculateBonus(salaryTechnical);
		
		/* SHOWING COVARIANT RETURN TYPE
		 * ONLY SUPPORTED WITH JAVA JDK >= 5.0
		 */
		Employee emp = new Employee("tempemp","acc1",34);
		Manager mng = new Manager("tempmng","acc2",67);
		emp.getDetails();
		mng.getDetails(); // Class Employee Constructor as well as Mnanager Constructor
		
		//Shows It's possible to override a parent method having differnt return type in child class 
		//but child's return type should be sub-class of parent's return type
		
		
		
		//Throwing Exception
		try {
			System.out.println(managers.size()/0);
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			System.out.println("Exception safely caught !");
		}
		
	}
	
}
