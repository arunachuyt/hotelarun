package com.payroll.services;

import java.sql.Connection;
import java.util.List;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Employee;

public interface IEmployee {
	public List<Employee> fetchAllData( String name) throws PayrollException ;
	public Employee fetchEmployeeById( int empId) throws PayrollException ;
	public int registerEmployee(Connection connObj, Employee employee) throws PayrollException ;
	public int updateEmployee(Connection connObj, Employee employee) throws PayrollException ;
	public String  saveWholeEmp(Employee employee ,String[] skills)throws PayrollException;
	public String	updateWholeEmp(Employee employee,String[] skills)throws PayrollException;


}
