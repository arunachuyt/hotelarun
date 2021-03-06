package com.onlinehotel.service;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.CustomerDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Customer;


@Service
public class CustomerService implements ICustomer {

	CustomerDAO customerDAO =new CustomerDAO();
	public CustomerService() {
		// TODO Auto-generated constructor stub
	}

	public boolean loginCheck(Customer customer) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return customerDAO.loginCheck(customer);
	}

	public boolean registerCustomer(Customer customer) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return customerDAO.registerCustomer(customer);
	}

}
