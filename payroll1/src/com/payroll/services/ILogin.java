package com.payroll.services;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.LoginDetails;

public interface ILogin {
	public boolean loginCheck(LoginDetails loginDetails) throws PayrollException ;

}
