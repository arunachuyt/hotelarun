package com.onlinehotel.service;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingEntry;

public interface IBookingEntry {

	public int getBookingEntry(BookingEntry bookingEntry) throws OnlineHotelException;
	
}
