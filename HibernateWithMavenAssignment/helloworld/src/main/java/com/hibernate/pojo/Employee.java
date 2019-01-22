package com.hibernate.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="employee")
@Entity
public class Employee {
	
	@Id
	@Column(name="employeeID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer employeeID;
	
	@Column(name="employeeName")
	public String employeeName;

	@Column(name="employeeAge")
	public Integer employeeAge;

	@Column(name="companyID")
	public Integer companyID;

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public Integer getemployeeID() {
		return employeeID;
	}

	public void setemployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getemployeeName() {
		return employeeName;
	}

	public void setemployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getemployeeAge() {
		return employeeAge;
	}

	public void setemployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}	
	
	public String toString() {
		return this.employeeName+"|"+this.employeeID+"|"+this.employeeAge;
	}

}
