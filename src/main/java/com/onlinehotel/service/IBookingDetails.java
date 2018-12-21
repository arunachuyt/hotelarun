package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.BookingEntry;


public interface IBookingDetails {

	
	public String addNewBooking(List<BookingDetails> bookingList) throws OnlineHotelException;
	
	public List<BookingDetails> bill(BookingEntry bookingentry) throws OnlineHotelException;
	
	public double totalBillAmount(BookingEntry bookingentry) throws OnlineHotelException;
}
