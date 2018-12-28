package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.Customer;

public interface ICustomer {

	public boolean loginCheck(Customer customer) throws OnlineHotelException;
	
	public boolean registerCustomer(Customer customer) throws OnlineHotelException;
	
	public List<BookingDetails> listAllBooking(Customer customer) throws OnlineHotelException;
}
