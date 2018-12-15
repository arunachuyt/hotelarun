package com.payroll.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	private int departmentId;
	private int addressId;
	
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	private String skillStr;
	private int empId;
	private String empName;
	private double empSalary;
	private Department department;
	public Employee(int empId, String empName, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		
	}


	private Address address;
	private List<Skills> skillsList;
	
	
	
	
	public String getSkillStr() {
		return skillStr;
	}
	public void setSkillStr(String skillStr) {
		this.skillStr = skillStr;
	}
	
	@Override
	public String toString() {
		return "Employee [skillStr=" + skillStr + ", empId=" + empId + ", empName=" + empName + ", empSalary="
				+ empSalary + ", department=" + department + ", address=" + address + ", skillsList=" + skillsList
				+ "]";
	}
	public Employee(int empId, String empName, double empSalary, Department department, Address address,
			List<Skills> skillsList) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.department = department;
		this.address = address;
		this.skillsList = skillsList;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public Department getDepartment() {
		return department;
	}
	
	@Autowired
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Skills> getSkillsList() {
		return skillsList;
	}
	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}



	
	
	
	
	
}
