package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String EmployeeName;
	private String EmployeeAddress;
	private int EmployeeSalary;
	private String EmployeeEmail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return EmployeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		EmployeeAddress = employeeAddress;
	}
	public int getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		EmployeeSalary = employeeSalary;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", EmployeeName=" + EmployeeName + ", EmployeeAddress=" + EmployeeAddress
				+ ", EmployeeSalary=" + EmployeeSalary + ", EmployeeEmail=" + EmployeeEmail + "]";
	}
	
	
}


