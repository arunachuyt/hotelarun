package com.payroll.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payroll.dao.SkillDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Skills;
@Service
public class SkillService implements ISkill {

	SkillDAO skillDAO=new SkillDAO();
	public SkillService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registerSkill(Skills skills) throws PayrollException {
		// TODO Auto-generated method stub
		return skillDAO.registerSkill(skills);
	}

	@Override
	public List<Skills> fetchAllSkills() throws PayrollException {
		// TODO Auto-generated method stub
		return skillDAO.fetchAllSkills();
	}

}
