package com.payroll.services;

import java.sql.Connection;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.EmployeeSkillSet;

public interface ISkillSet {
	public int registerSkillSet(Connection connObj, EmployeeSkillSet skillSet) throws PayrollException ;
	public int removeSkillSet(Connection connObj, int empId) throws PayrollException ;


}
