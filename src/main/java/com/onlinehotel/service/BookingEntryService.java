package com.onlinehotel.service;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.BookingEntryDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingEntry;

@Service
public class BookingEntryService implements IBookingEntry {

	BookingEntryDAO bookingEntryDAO=new BookingEntryDAO();
	public BookingEntryService() {
		// TODO Auto-generated constructor stub
	}

	public int getBookingEntry(BookingEntry bookingEntry) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return bookingEntryDAO.getBookingEntry(bookingEntry);
	}

}
