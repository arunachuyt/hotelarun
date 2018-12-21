package com.onlinehotel.service;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Customer;

public interface ICustomer {

	public boolean loginCheck(Customer customer) throws OnlineHotelException;
	
	public boolean registerCustomer(Customer customer) throws OnlineHotelException;
}
