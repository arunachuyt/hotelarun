package com.payroll.services;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.payroll.dao.AddressDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;

@Service
public class AddressService implements IAddress {

	
	
	AddressDAO addressDao=new AddressDAO();
	public AddressService() {
	}

	@Override
	public int registerAddress(Connection connObj, Address address) throws PayrollException {

     
		return  addressDao.registerAddress(connObj, address);
		
	}

	@Override
	public int updateAddress(Connection connObj, Address address) throws PayrollException {
		// TODO Auto-generated method stub
		return addressDao.updateAddress(connObj, address);
	}

}
