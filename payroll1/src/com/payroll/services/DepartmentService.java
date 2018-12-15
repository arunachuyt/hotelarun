package com.payroll.services;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payroll.dao.DepartmentDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Department;
@Service
public class DepartmentService implements IDepartment {

	DepartmentDAO departmentDAO=new DepartmentDAO();
	
	public DepartmentService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registerDepartment(Connection connObj, Department department) throws PayrollException {
	
		
		
		return departmentDAO.registerDepartment(connObj, department);
	}

	@Override
	public List<Department> fetchAllDepartments() throws PayrollException {
		// TODO Auto-generated method stub
		return departmentDAO.fetchAllDepartments();
	}

}
