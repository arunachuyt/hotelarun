package com.payroll.services;

import java.sql.Connection;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;

public interface IAddress {
	public int registerAddress(Connection connObj,Address address) throws PayrollException;
	public int updateAddress(Connection connObj,Address address) throws PayrollException;

}
