package com.payroll.model;

public class EmployeeSkillSet {

	public EmployeeSkillSet() {
		// TODO Auto-generated constructor stub
	}

	private int empSkillSetId;
	private Skills skills;
	private Employee employee;
	
	
	
	public int getEmpSkillSetId() {
		return empSkillSetId;
	}
	public void setEmpSkillSetId(int empSkillSetId) {
		this.empSkillSetId = empSkillSetId;
	}
	public Skills getSkills() {
		return skills;
	}
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public EmployeeSkillSet(int empSkillSetId, Skills skills, Employee employee) {
		super();
		this.empSkillSetId = empSkillSetId;
		this.skills = skills;
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "EmployeeSkillSet [empSkillSetId=" + empSkillSetId + ", skills=" + skills + ", employee=" + employee
				+ "]";
	}
	
	
	
	
	
}
