package com.payroll.services;

import java.sql.Connection;
import java.util.List;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Department;

public interface IDepartment {

	public int registerDepartment(Connection connObj, Department department) throws PayrollException;
	public List<Department> fetchAllDepartments () throws PayrollException ;

	
}
