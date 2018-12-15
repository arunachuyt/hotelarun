package com.payroll.services;

import java.util.List;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Skills;

public interface ISkill {
	public int registerSkill(Skills skills) throws PayrollException;
	public List<Skills> fetchAllSkills() throws PayrollException ;

		
}
