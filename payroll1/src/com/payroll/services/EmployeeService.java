package com.payroll.services;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.dao.EmployeeDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.model.Department;
import com.payroll.model.Employee;
@Service
public class EmployeeService implements IEmployee {


	
	

	
	EmployeeDAO employeeDAO=new EmployeeDAO();
	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> fetchAllData(String name) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.fetchAllData(name);
	}

	@Override
	public Employee fetchEmployeeById(int empId) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.fetchEmployeeById(empId);
	}

	@Override
	public int registerEmployee(Connection connObj, Employee employee) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.registerEmployee(connObj, employee);
	}

	@Override
	public int updateEmployee(Connection connObj, Employee employee) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(connObj, employee);
	}

	@Override
	public String saveWholeEmp(Employee employee, String[] skills) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.saveWholeEmp(employee, skills);
	}

	@Override
	public String updateWholeEmp(Employee employee, String[] skills) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeDAO.updateWholeEmp(employee, skills);
	}

}
