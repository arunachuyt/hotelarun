package com.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.dao.LoginDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.model.Department;
import com.payroll.model.LoginDetails;

@Service
public class LoginService implements ILogin {
	@Override
	public String toString() {
		return "LoginService [loginDAO=" + loginDAO + ", address=" + address + ", department=" + department + "]";
	}

	LoginDAO loginDAO=new LoginDAO();

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean loginCheck(LoginDetails loginDetails) throws PayrollException {
		// TODO Auto-generated method stub
		return loginDAO.loginCheck(loginDetails);
	}
	
	Address address;
	Department department;
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	
    @Autowired
	public void setDepartment(Department department) {
		this.department = department;
	}

}
