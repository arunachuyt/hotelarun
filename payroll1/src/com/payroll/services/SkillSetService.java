package com.payroll.services;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.payroll.dao.EmployeeSkillSetDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.EmployeeSkillSet;
@Service
public class SkillSetService implements ISkillSet {

	EmployeeSkillSetDAO employeeSkillSetDAO=new EmployeeSkillSetDAO();
	
	public SkillSetService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registerSkillSet(Connection connObj, EmployeeSkillSet skillSet) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeSkillSetDAO.registerSkillSet(connObj, skillSet);
	}

	@Override
	public int removeSkillSet(Connection connObj, int empId) throws PayrollException {
		// TODO Auto-generated method stub
		return employeeSkillSetDAO.removeSkillSet(connObj, empId);
	}

}
